package com.zz.supercleaner.ui;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ajguan.library.IRefreshHeader;
import com.ajguan.library.State;
import com.zz.supercleaner.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RefreshView extends LinearLayout implements IRefreshHeader {
    public RefreshView(Context context) {
        super(context);
    }

    public RefreshView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @BindView(R.id.icon)
    ImageView iconView;

    @BindView(R.id.text)
    TextView textView;

    AnimationDrawable animationDrawable;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
//        iconView.setImageResource(R.drawable.refresh_anim);
        animationDrawable = (AnimationDrawable) iconView.getDrawable();
    }

    @Override
    public void reset() {
        animationDrawable.stop();
    }

    @Override
    public void pull() {

    }

    @Override
    public void refreshing() {
        animationDrawable.start();
    }

    @Override
    public void onPositionChange(float v, float v1, float v2, boolean b, State state) {

    }

    @Override
    public void complete() {
        animationDrawable.stop();
    }
}
