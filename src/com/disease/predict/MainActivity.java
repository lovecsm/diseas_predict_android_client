package com.disease.predict;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	}
	public void stomach(View v){
        Toast.makeText(MainActivity.this, "你选择了胃病预测", 2000).show();  
        Intent intent=new Intent(MainActivity.this, StomachActivity.class);
        startActivity(intent);
    }  
	public void a(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void b(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void c(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void d(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void e(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void f(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void g(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
	public void h(View v) {
		Toast.makeText(MainActivity.this, "抱歉，该功能暂未开放", 2000).show();  
	}
}