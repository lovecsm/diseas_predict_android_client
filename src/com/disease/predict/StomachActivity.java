package com.disease.predict;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class StomachActivity extends Activity {
	EditText getIpAddress = null;
	CheckBox weakness = null;
	CheckBox hematochezia = null;
	CheckBox cold = null;
	CheckBox acid = null;
	CheckBox fever = null;
	CheckBox emesis = null;
	CheckBox coldness = null;
	CheckBox ulcer = null;
	CheckBox nausea = null;
	CheckBox tract = null;
	CheckBox crater = null;
	CheckBox fibrillation = null;
	CheckBox collywobbles = null;
	CheckBox mass = null;
	CheckBox stomachache = null;
	CheckBox bleeding = null;
	CheckBox microStomachache = null;
	CheckBox ventosity = null;
	CheckBox pallor = null;

	/* 下面写症状数组 */
	final String symbols[] = { "下肢无力,", "便血,", "冷汗,", "反酸,", "发烧,", "呕吐,", "四肢发冷,", "幽门管溃疡,", "恶心,", "消化道穿孔,",
			"溃疡外观呈火山口样,", "肌肉纤维震颤,", "肚子疼,", "腹部肿块,", "胃疼,", "胃肠道出血,", "胃部隐痛,", "腹胀,", "面色苍白\n" };
	final int sign[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	String saveCsv = ""; // 保存结果的字符串

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.stomach_activity);

		/* 下面是对CheckBox的ID进行获取并监听 */
		weakness = (CheckBox) findViewById(R.id.weakness);
		hematochezia = (CheckBox) findViewById(R.id.hematochezia);
		cold = (CheckBox) findViewById(R.id.cold);
		acid = (CheckBox) findViewById(R.id.acid);
		fever = (CheckBox) findViewById(R.id.fever);
		emesis = (CheckBox) findViewById(R.id.emesis);
		coldness = (CheckBox) findViewById(R.id.coldness);
		ulcer = (CheckBox) findViewById(R.id.ulcer);
		nausea = (CheckBox) findViewById(R.id.nausea);
		tract = (CheckBox) findViewById(R.id.tract);
		crater = (CheckBox) findViewById(R.id.crater);
		fibrillation = (CheckBox) findViewById(R.id.fibrillation);
		collywobbles = (CheckBox) findViewById(R.id.collywobbles);
		mass = (CheckBox) findViewById(R.id.mass);
		stomachache = (CheckBox) findViewById(R.id.stomachache);
		bleeding = (CheckBox) findViewById(R.id.bleeding);
		microStomachache = (CheckBox) findViewById(R.id.microStomachache);
		ventosity = (CheckBox) findViewById(R.id.ventosity);
		pallor = (CheckBox) findViewById(R.id.pallor);
		//对编辑框的ID进行获取
		getIpAddress = (EditText)findViewById(R.id.ipAddress);
		// 对weakness进行监听
		weakness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[0] = 1;
				} else {
					sign[0] = 0;
				}
			}
		});
		// 对hematochezia进行监听
		hematochezia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[1] = 1;
				} else {
					sign[1] = 0;
				}
			}
		});
		// 对cold进行监听
		cold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[2] = 1;
				} else {
					sign[2] = 0;
				}
			}
		});

		// 对acid进行监听
		acid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[3] = 1;
				} else {
					sign[3] = 0;
				}
			}
		});

		// 对fever进行监听
		fever.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[4] = 1;
				} else {
					sign[4] = 0;
				}
			}
		});

		// 对emesis进行监听
		emesis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[5] = 1;
				} else {
					sign[5] = 0;
				}
			}
		});// 对coldness进行监听
		coldness.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[6] = 1;
				} else {
					sign[6] = 0;
				}
			}
		});

		// 对ulcer进行监听
		ulcer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[7] = 1;
				} else {
					sign[7] = 0;
				}
			}
		});
		// 对nausea进行监听
		nausea.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[8] = 1;
				} else {
					sign[8] = 0;
				}
			}
		});

		// 对tract进行监听
		tract.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[9] = 1;
				} else {
					sign[9] = 0;
				}
			}
		});

		// 对crater进行监听
		crater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[10] = 1;
				} else {
					sign[10] = 0;
				}
			}
		});
		// 对fibrillation进行监听
		fibrillation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[11] = 1;
				} else {
					sign[11] = 0;
				}
			}
		});

		// 对collywobbles进行监听
		collywobbles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[12] = 1;
				} else {
					sign[12] = 0;
				}
			}
		});

		// 对mass进行监听
		mass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[13] = 1;
				} else {
					sign[13] = 0;
				}
			}
		});

		// 对stomachache进行监听
		stomachache.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[14] = 1;
				} else {
					sign[14] = 0;
				}
			}
		});

		// 对bleeding进行监听
		bleeding.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[15] = 1;
				} else {
					sign[15] = 0;
				}
			}
		});

		// 对microStomachache进行监听
		microStomachache.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[16] = 1;
				} else {
					sign[16] = 0;
				}
			}
		});

		// 对ventosity进行监听
		ventosity.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[17] = 1;
				} else {
					sign[17] = 0;
				}
			}
		});

		// 对pallor进行监听
		pallor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					sign[18] = 1;
				} else {
					sign[18] = 0;
				}
			}
		});
		/* CheckBox监听设置完毕 */

	}

	// 保存文件
	public void postData(View v) {
		/* 先对结果进行预处理 */
		saveCsv = "";
		for (int i = 0; i < 19; i++) {
			saveCsv += symbols[i];
		}
		for (int i = 0; i < 19; i++) {
			saveCsv += (sign[i] + "");
			if (i != 18)
				saveCsv += ",";
		}
		// 保存文件
		saveFile(saveCsv);
		saveCsv = "";
		for (int i = 0; i < 19; i++) {
			saveCsv += (sign[i] + "");
		}
		sendRequestWithHttpURLConnection();//向服务器提交数据
	}

	// 分享文件
	public void share(View v) {
		String filePath = null;
		boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if (hasSDCard) { // SD卡根目录的predict_data.csv
			filePath = Environment.getExternalStorageDirectory().toString() + File.separator + "predict_data.csv";
		} else {
			Toast.makeText(this, "保存失败，SD卡不存在", 3000);
		}
		if (fileIsExists(filePath)) {
			shareFile(this, filePath);
		} else {
			Toast.makeText(this, "分享失败，文件不存在", 3000);
		}
	}

	// 文件保存函数
	public void saveFile(String str) {
		String filePath = null;
		boolean hasSDCard = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		if (hasSDCard) { // SD卡根目录的predict_data.csv
			filePath = Environment.getExternalStorageDirectory().toString() + File.separator + "predict_data.csv";

		} else // 系统下载缓存根目录的predict_data.csv
			filePath = Environment.getDownloadCacheDirectory().toString() + File.separator + "predict_data.csv";

		try {
			File file = new File(filePath);
			if(file.isFile()&&file.exists()) {  
	            file.delete();
	            //Toast.makeText(getApplicationContext(), "文件已删除", 4000).show();
	        }  
			if (!file.exists()) {
				File dir = new File(file.getParent());
				dir.mkdirs();
				file.createNewFile();
			}
			FileOutputStream outStream = new FileOutputStream(file);
			outStream.write(str.getBytes());
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Toast.makeText(getApplicationContext(), "文件已保存到" + filePath, 4000).show();
	}

	// 判断文件是否存在
	public boolean fileIsExists(String strFile) {
		try {
			File f = new File(strFile);
			if (!f.exists()) {
				return false;
			}

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	// 分享文件函数
	public void shareFile(Context context, String filePath) {
		File file = new File(filePath);
		if (null != file && file.exists()) {
			Intent share_intent = new Intent();
			share_intent.setAction(Intent.ACTION_SEND);// 设置分享行为
			share_intent.setType("*/*");// 设置分享内容的类型
			share_intent.putExtra(Intent.EXTRA_SUBJECT, "分享预测数据");
			share_intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
			share_intent = Intent.createChooser(share_intent, "分享到");
			startActivity(Intent.createChooser(share_intent, "分享到"));
		} else {
			Toast.makeText(this, "分享失败，文件不存在", 3000);
		}
	}
	//访问服务器提交数据并返回结果
	private void sendRequestWithHttpURLConnection() {
		final String app_data = saveCsv;
		final String ip = getIpAddress.getText()+"";
		//dialog("ip", ip);
		/*增加一个对IP地址合法性的判断*/
		String testIp = "((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))):\\d+";
		Pattern p = Pattern.compile(testIp);
		Matcher matcher = p.matcher(ip);
		if (matcher.find()) {
		// 开启线程来发起网络请求
		new Thread(new Runnable() {
			@Override
			public void run() {
				Looper.prepare(); 
				HttpURLConnection connection = null;
				BufferedReader reader = null;
				String originalUrl = "http://" + ip + "/" + app_data;
				//dialog("ip", originalUrl);
				try {
					URL url = new URL(originalUrl);
					Toast.makeText(getApplicationContext(), originalUrl, 4000);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					// 下面对获取到的输入流进行读取
					reader = new BufferedReader(new InputStreamReader(in));
					StringBuilder response = new StringBuilder();
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
					show(response.toString());
				} catch (Exception e) {
					e.printStackTrace();
					dialog("错误","连接超时！请检查服务器IP地址正确与否");
				} finally {
					if (reader != null) {
						try {
							reader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (connection != null) {
						connection.disconnect();
					}
				}
				Looper.loop(); 
			}
			
		}).start();}else {
			dialog("错误", "IP地址不合法");
		}
		}
	

	private void show(String response) {
		String Regex = ">(\\w+)<?";
		Pattern p = Pattern.compile(Regex);
		Matcher matcher = p.matcher(response);
		if (matcher.find()) {
			// 在这里进行 UI 操作，将结果显示到界面上
			String showResult = "";
			if(matcher.group(1).equals("youmenluoganjun")) {
				showResult = "幽门螺杆菌感染";
			}
			else if(matcher.group(1).equals("mengzhongdu")) {
				showResult = "锰中毒";
			}
			else if(matcher.group(1).equals("kuiyangbingchuankong")) {
				showResult = "溃疡病穿孔";
			}
			else if(matcher.group(1).equals("weizhifangliu")) {
				showResult = "胃脂肪瘤";
			}
			else if(matcher.group(1).equals("weikuiyang")) {
				showResult = "胃溃疡";
			}
			else if(matcher.group(1).equals("health")) {
				showResult = "你很健康！继续保持哦";
			}
			else {
				//showResult = "服务器数据已更新，请联系管理员";
				showResult = matcher.group(1);
			}
			//Toast.makeText(getApplicationContext(), showResult, 4000);
			//对话框位置，弹出服务器的响应 
			dialog("预测结果", showResult);
		} else {
			Toast.makeText(getApplicationContext(), "正则表达式未匹配", 4000);
		}
	}
	
	//提示框
	public void dialog(String title, String msg) {  
        // 创建对话框对象  
        AlertDialog alertDialog = new AlertDialog.Builder(this).create(); 
        // 设置对话框的标题  
        alertDialog.setTitle(title);  
        // 设置对话框中的内容  
        alertDialog.setMessage(msg);  
        // 显示对话框  
        alertDialog.show();  
    }  

}
