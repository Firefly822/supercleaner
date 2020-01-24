package com.zz.supercleaner.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.zz.supercleaner.R;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private TextView toolbarTitle;
    private ImageView toolbarIcon;
    private boolean isVisible = false;

    public boolean isVisible(){
        return isVisible;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isVisible = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        isVisible = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void setContentView(int layoutResId) {
        View layoutView = getLayoutInflater().inflate(layoutResId, null);
        setContentView(layoutView);
        ButterKnife.bind(this);
    }

    @Override
    public void setContentView(View view) {
        if (!hasToolbar()){
            super.setContentView(view);
        } else {
            View root = generateToolbarView(view);
            initToolbar(root);
            super.setContentView(root);
        }

    }

    public View generateToolbarView(View view){
        View root = getLayoutInflater().inflate(R.layout.activity_base, null);
        ((ViewGroup)root.findViewById(R.id.root_container)).addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return root;
    }

    protected boolean hasToolbar(){
        return true;
    }

    protected Toolbar getToolbar() {
        return mToolbar;
    }

    protected String getToolbarTitle() {
        return getString(R.string.app_name);
    }

    protected void initToolbar(View view) {
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        if(mToolbar != null) {
            //mToolbar.setLogo(R.drawable.ic_launcher);
            mToolbar.setTitle(getToolbarTitle());
            // mToolbar.setSubtitle("副标题");
            mToolbar.setTitleTextColor(Color.WHITE);
            setSupportActionBar(mToolbar);

            toolbarTitle = (TextView) mToolbar.findViewById(R.id.toolbar_title);
            toolbarIcon = mToolbar.findViewById(R.id.toolbar_icon);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            //must do it after setSupportActionBar
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    onToolbarNavUp();
                }
            });

        }
    }

    public void setHomeAsUpEnable(boolean enable){
        if(getSupportActionBar()!=null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(enable);
        }
    }

    protected void onToolbarNavUp() {
        //default is back
        onBackPressed();
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if(toolbarTitle!=null){
            toolbarTitle.setText(title);
            toolbarIcon.setVisibility(View.GONE);
        }
    }

    public void setToolbarIcon(int resId) {
        if (toolbarIcon != null) {
            toolbarIcon.setVisibility(View.VISIBLE);
            toolbarIcon.setImageResource(resId);
            toolbarTitle.setText("");
        }
    }

    protected void showFragment(int containerId, Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(containerId, fragment).commitAllowingStateLoss();
    }
}
