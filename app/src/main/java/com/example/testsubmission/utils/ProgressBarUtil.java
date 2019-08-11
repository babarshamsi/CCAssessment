package com.example.testsubmission.utils;

import android.app.Activity;


public class ProgressBarUtil {

    private static SpinnerProgressDialog spinnerProgressDialog;

    public static void showSpinnerProgressDialog(Activity activity) {
        try {
            spinnerProgressDialog = new SpinnerProgressDialog(activity);
            spinnerProgressDialog.setCanceledOnTouchOutside(true);

            if (!spinnerProgressDialog.isShowing())
                spinnerProgressDialog.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isSpinnerLoading(Activity activity){


        if (spinnerProgressDialog == null) {
            spinnerProgressDialog = new SpinnerProgressDialog(activity);
            spinnerProgressDialog.setCanceledOnTouchOutside(false);
        }else {

        }
        return spinnerProgressDialog.isShowing();
    }


    public static void hideSpinnerProgressDialog() {
        try {
            if (spinnerProgressDialog != null && spinnerProgressDialog.isShowing()) {
                spinnerProgressDialog.dismiss();
                spinnerProgressDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
