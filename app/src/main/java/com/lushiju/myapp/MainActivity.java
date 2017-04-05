package com.lushiju.myapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lushiju.myapp.base.BaseActivity;
import com.lushiju.myapp.view.CircleImageView;
import com.nineoldandroids.view.ViewHelper;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.circleImg)
    CircleImageView circleImg;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.menu)
    ImageView menu;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initAllMembersView(Bundle savedInstanceState) {
        initView();
        initEvents();
    }
    @OnClick({R.id.circleImg})
    public void handleEvent(View view){
       switch (view.getId()){
           case R.id.circleImg:
               if (drawer.isDrawerOpen(GravityCompat.START)) {
                   drawer.closeDrawer(GravityCompat.START);
               }else {
                   drawer.openDrawer(GravityCompat.START,true);
               }
               break;
       }
    }
    private void initView() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

    }
    private void initEvents() {
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View mContent = drawer.getChildAt(0);
                View mMenu = drawerView;
                float scale = 1 - slideOffset;
//                float rightScale = 0.8f + scale * 0.2f;
//                float leftScale = 1 - 0.3f * scale;
//                ViewHelper.setScaleX(mMenu, leftScale);
//                ViewHelper.setScaleY(mMenu, leftScale);
//                ViewHelper.setAlpha(mMenu, 0.6f + 0.4f * (1 - scale));
                  ViewHelper.setTranslationX(mContent,
                            mMenu.getMeasuredWidth() * (1 - scale));
//                  ViewHelper.setPivotX(mContent, 0);
//                  ViewHelper.setPivotY(mContent,
//                            mContent.getMeasuredHeight() / 2);
//                  mContent.invalidate();
//                  ViewHelper.setScaleX(mContent, rightScale);
//                  ViewHelper.setScaleY(mContent, rightScale);
                }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
