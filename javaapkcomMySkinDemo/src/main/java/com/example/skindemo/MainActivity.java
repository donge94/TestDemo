package com.example.skindemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private SkinSettingManager mSettingManager;
    private Button btn;
    private LinearLayout[] layout;
    private int[] layouts={R.id.mylayout,R.id.mylayout1};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.button1);
        btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,MySkin.class);
            startActivity(intent);
			}
		});
    }
    //每个页面都要重写这个方法和初始化皮肤的方法
    @Override
    protected void onResume() {
    	//初始化皮肤
    	layout=new LinearLayout[layouts.length];
    	for(int i=0; i<layouts.length; i++){
    		layout[i]=(LinearLayout) findViewById(layouts[i]);
    		mSettingManager=new SkinSettingManager(MainActivity.this,layout[i]);
    		mSettingManager.initSkins();
    	}
    	super.onResume();
    }
}
