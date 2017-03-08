package com.sky.slidingmenu;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Sky on 2017/3/6.
 */

public class LoginActivity extends BaseColorActivity implements View.OnClickListener {

    private Intent intent;
    private ImageView imageView;
    private ImageView imageId;
    private Boolean imageBoolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        //
        imageView = (ImageView) findViewById(R.id.headimg);
//        imageView.setOnClickListener(this);
//        //
        Button button = (Button) findViewById(R.id.loginButton);
//        button.setOnClickListener(this);
        /*
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                this.finish();
                startActivity(intent);
            }
        });
//        imageId = (ImageView) findViewById(R.drawable.hg);

        imageView = (ImageView) findViewById(R.id.headimg);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageBoolean){
                    imageView.setImageResource(R.drawable.hg);
                    imageBoolean = false;
                    Log.i("1","2");
                }else {
                    imageView.setImageResource(R.drawable.ly);
                    imageBoolean = true;
                    Log.i("1","4");
                }
            }
        });*/

    }

    /**
     * 响应ID对应组件点击事件
     * */
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.loginButton: {
//                Log.i("login", "error");
                intent = new Intent(LoginActivity.this, MainActivity.class);
                this.finish();
                startActivity(intent);
                break;
            }
            case R.id.headimg: {
                if (imageBoolean) {
                    imageView.setImageResource(R.drawable.hg);
//                    setHeading(getDrawable(R.drawable.hg));
                    imageBoolean = false;
//                    Log.i("1", "2");
                } else {
                    imageView.setImageResource(R.drawable.ly);
//                    setHeading(R.drawable.hg);
                    imageBoolean = true;
//                    Log.i("1", "4");
                }
                break;
            }

        }
    }

    /**
     * 实现父类方法，并完成界面布局文件绑定
     * */
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }
//
//    public void setHeading(int heading_Id){
////        return imageView.getId();
//        super.heading_Id=heading_Id;
//    }

}
