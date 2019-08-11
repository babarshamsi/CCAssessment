package com.example.testsubmission.utils;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

import com.example.testsubmission.R;

public class SpinnerProgressDialog extends Dialog {

    //public static final String TAG = SpinnerProgressDialog.class.getSimpleName();

    ProgressBar mSpinner;
    Activity mActivity;



    public OnItemSelectedListener listener;

    public interface OnItemSelectedListener {
        void onSpinnerDialogDismiss();
    }

    public SpinnerProgressDialog(Activity activity) {
        super(activity);
        mActivity = activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setBackgroundDrawable(mActivity.getResources().getDrawable(R.drawable.spinner_bg_fill));

        setContentView(R.layout.widget_spinnerprogress_dialog);

        mSpinner = (ProgressBar) findViewById(R.id.spinner_pbar);


        mSpinner.setVisibility(View.VISIBLE);
        mSpinner.getIndeterminateDrawable().setColorFilter(mActivity.getResources().getColor(R.color.colorBlack), android.graphics.PorterDuff.Mode.MULTIPLY);


    }

    @Override
    public void setOnCancelListener(OnCancelListener listener) {
        super.setOnCancelListener(listener);

    }

    @Override
    public void setOnDismissListener(OnDismissListener listener) {
        super.setOnDismissListener(listener);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //return super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK && listener != null) {
            listener.onSpinnerDialogDismiss();
        }
        return true;
    }
}

