package com.stormdzh.downopenview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/3/30.
 */
public class ViewDownOpen extends LinearLayout implements View.OnClickListener {

    private boolean mOpenStata;
    private RelativeLayout rlTitle;
    private ImageView ivArrow;
    private TextView tvContentView;

    public ViewDownOpen(Context context) {
        this(context, null);
    }

    public ViewDownOpen(Context context, AttributeSet attrs) {
        this(context, attrs, false);
    }

    public ViewDownOpen(Context context, AttributeSet attrs, boolean isOpen) {
        super(context, attrs);
        init(context, isOpen);
    }

    private void init(Context context, boolean isOpen) {
        LayoutInflater.from(context).inflate(R.layout.view_downopen, this);
        rlTitle = (RelativeLayout) findViewById(R.id.rlTitle);
        ivArrow = (ImageView) findViewById(R.id.ivArrow);
        tvContentView = (TextView) findViewById(R.id.tvContentView);
        findViewById(R.id.rlTitle).setOnClickListener(this);
        openView(isOpen);
    }

    private void openView(boolean isOpen) {
        mOpenStata = isOpen;
        if (isOpen) {
            ivArrow.setSelected(true);
            setContentShow(true);
        } else {
            ivArrow.setSelected(false);
            setContentShow(false);
        }
    }

    private void setContentShow(boolean isShow) {
        if (isShow) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tvContentView.getLayoutParams();
            layoutParams.height = LayoutParams.WRAP_CONTENT;
            tvContentView.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tvContentView.getLayoutParams();
            layoutParams.height = com.stormdzh.downopenview.AppUtils.dp2px(getContext(),51);
            tvContentView.setLayoutParams(layoutParams);
        }
    }

    public boolean ismOpenStata() {
        return mOpenStata;
    }

    public void setmOpenStata(boolean mOpenStata) {
        this.mOpenStata = mOpenStata;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rlTitle:
                if (mOpenStata) {
                    openView(false);
                } else {
                    openView(true);
                }
                break;
            default:
                break;
        }
    }
}
