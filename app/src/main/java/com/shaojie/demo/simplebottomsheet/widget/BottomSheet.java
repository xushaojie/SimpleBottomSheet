package com.shaojie.demo.simplebottomsheet.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.shaojie.demo.simplebottomsheet.R;


/**
 * 底部弹出框
 *
 * @author Shaojie
 * @date 2016-04-13 17:23
 */
public abstract class BottomSheet extends Dialog implements DialogInterface {

    public Activity mActivity;

    public BottomSheet(Activity activity) {
        super(activity, R.style.BottomSheet_Dialog);
        mActivity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        // 必须在init()之后设置
        int screenHeight = mActivity.getResources().getDisplayMetrics().heightPixels;
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = (int) (screenHeight * heightPercent());
        params.gravity = Gravity.BOTTOM;
        getWindow().setAttributes(params);
    }

    /**
     * 弹出框高度占屏幕百分比，取值范围(0,1]，1表示100%，0.5表示50%，其余类推
     *
     * @return 默认为0.5f
     */
    public float heightPercent() {
        return 0.5f;
    }

    public abstract int getContentLayoutId();

    public abstract void initView(View root);

    private void init() {
        View root = View.inflate(mActivity, getContentLayoutId(), null);
        setContentView(root);
        initView(root);
    }

}
