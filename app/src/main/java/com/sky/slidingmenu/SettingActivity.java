package com.sky.slidingmenu;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sky on 2017/3/6.
 */


public class SettingActivity extends BaseColorActivity {

    private ImageView account_Image;
    private ImageView heading;
    private TextView textView;

//    private long id;
    private Drawable drawable;
    private Intent intent;
    private LoginActivity loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        account_Image = (ImageView) findViewById(R.id.account_image);
//        heading = (ImageView) findViewById(R.id.headimg);
        Log.d("image","head");
        setHeading();
    }


    /**
     * 实现父类方法，并使用父类方法设置界面布局文件
     * */
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_setting;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            finish();
        }
        return true;

    }


    /**
     * 设置界面组件点击事件
     * */
    public void onClick(View view){
        switch (view.getId()){
            case R.id.login_again:{
                if(intent == null)
                    intent = new Intent(SettingActivity.this,LoginActivity.class);
                this.finish();
                startActivity(intent);
            }
        }
    }




    /**
     * 判断当前账号
     * 并设置显示对应头像，账号，以及部分信息
     * */
    public void setHeading( ){
        //TODO 使用本地文件读取数据


    }

    public boolean duibi(int str){
        return heading_Id == str;

    }

}
