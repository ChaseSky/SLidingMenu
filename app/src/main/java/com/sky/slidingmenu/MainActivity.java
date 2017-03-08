package com.sky.slidingmenu;

import android.annotation.TargetApi;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sky.slidingmenu.fragment.FragmentCenter;
import com.sky.slidingmenu.fragment.FragmentLeft;
import com.sky.slidingmenu.fragment.FragmentRight;
import com.sky.slidingmenu.view.SlidingMenu;

public class MainActivity extends BaseColorActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentLeft fragmentLeft;
    private FragmentCenter fragmentCenter;
    private FragmentRight fragmentRight;

    private Intent settingIntent;
    private RadioGroup radioGroup;
    private SlidingMenu mLeftMenu;
    private ImageView mainImageViewLeft;
    private ImageView mainImageViewCenter;
    private ImageView mainImageViewRight;
    private Button toggMenuButton;
    private ImageButton settingButton;
    private TextView exitButton;


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.activity_main);
        //设置默认Fragment
        setDefaultFragment();
        /**
         * 左滑菜单
         * */
        mLeftMenu = (SlidingMenu) findViewById(R.id.id_menu);
        /**
         * 右屏幕左中右三图
         * */
        mainImageViewLeft = (ImageView) findViewById(R.id.mainImageidLeft);
        mainImageViewCenter = (ImageView) findViewById(R.id.mainImageidCenter);
        mainImageViewRight = (ImageView) findViewById(R.id.mainImageidRight);
        /**
         * 主屏左上角切换菜单状态按钮
         * */
        toggMenuButton = (Button) findViewById(R.id.togglrMenu);
        toggMenuButton.setOnClickListener(this);
        /**
         * 下方切换fragment按钮
         * */
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
        /**
         * 设置按钮
         * */
        settingButton = (ImageButton) findViewById(R.id.settingButton);
        settingButton.setOnClickListener(this);
        /**
         * 退出应用按钮
         * */
        exitButton = (TextView) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(this);


//        Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.fade);
//        getWindow().setExitTransition(explode);


    }

    /**
     * 返回布局文件ID让其设置显示布局
     */
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }


    /**
     * 添加左上角菜单状态切换button
     */
    public void toggleMenu(View view) {
        mLeftMenu.toggle();
    }

    /**
     * 右屏图片点击事件
     */
    public void imageOnClick(View v) {
        Toast.makeText(this, v.getId() + " ", Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置默认显示在主屏的fragment
     */
    public void setDefaultFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentLeft = new FragmentLeft();
        fragmentCenter = new FragmentCenter();
        fragmentRight = new FragmentRight();
        fragmentTransaction.add(R.id.mainFragment, fragmentLeft);
        fragmentTransaction.commit();
    }


    /**
     * 设置主屏下方三个RadioButton点击事件
     */
    public void onCheckedChanged(RadioGroup group, int checkdId) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (checkdId) {

            case R.id.radioLeft: {
                if (fragmentLeft == null)
                    fragmentLeft = new FragmentLeft();
                fragmentTransaction.replace(R.id.mainFragment, fragmentLeft);
                fragmentTransaction.commit();
                Toast.makeText(this, "这是左屏", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.radioCenter: {
                if (fragmentCenter == null)
                    fragmentCenter = new FragmentCenter();
                fragmentTransaction.replace(R.id.mainFragment, fragmentCenter);
                fragmentTransaction.commit();
                Toast.makeText(this, "这是中屏", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.radioRight: {
                if (fragmentRight == null)
                    fragmentRight = new FragmentRight();
                fragmentTransaction.replace(R.id.mainFragment, fragmentRight);
                fragmentTransaction.commit();
                Toast.makeText(this, "这是右屏", Toast.LENGTH_SHORT).show();
                break;
            }
        }

    }


    /**
     * 响应按钮点击事件
     * */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.togglrMenu: {
                mLeftMenu.toggle();
                break;
            }
            case R.id.exitButton: {
                finish();
                break;
            }
            case R.id.settingButton: {
                /**
                 * 绑定设置Activity窗体
                 * */
                if (settingIntent == null)
                    settingIntent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(settingIntent);
                break;
            }

        }

    }

    /**
     * 监听返回按键并提供返回桌面功能
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent home = new Intent(Intent.ACTION_MAIN);
            home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            home.addCategory(Intent.CATEGORY_HOME);
            startActivity(home);
        }
        return true;

    }


    public void exitClick(View v) {
        System.exit(0);
    }

    public void startSetting(View v) {
        startActivity(settingIntent);
    }

}
