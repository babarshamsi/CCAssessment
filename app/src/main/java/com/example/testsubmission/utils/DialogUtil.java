package com.example.testsubmission.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.testsubmission.R;

public class DialogUtil {

    public static void showAlertMessage(Activity context, String message, String content, String label) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(message)
                .setMessage(content)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setCancelable(false);


//        MaterialDialog dialog = builder.build();
        builder.show();

    }

    public static void showAlertMessageForLocationsAndInternet(final Activity context, String locationMessage, String LocationContent, final String label, final String internetMessage, final String internetContent) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(locationMessage)
                .setMessage(LocationContent)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        showAlertMessage(context, internetMessage, internetContent, context.getString(R.string.ok));
                    }
                });


//        MaterialDialog dialog = builder.build();
        builder.show();

    }

    public static void showAlertMessageEnableLocation(final Activity mActivity, String message, final String content, String positiveLabel, String negativeLabel) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity)
                .setTitle(message)
                .setMessage(content)
                .setCancelable(false)
                .setPositiveButton(positiveLabel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setNegativeButton(negativeLabel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mActivity.startActivityForResult(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS), PermissionsUtil.PERMISSIONS_REQUEST_LOCATION);

                        if (dialogInterface != null) {
                            dialogInterface.dismiss();
                        }
                    }
                });

        builder.show();

    }

    //showing toast
    public static void showToast(Context context,String mesaage){
        Toast.makeText(context,mesaage,Toast.LENGTH_SHORT).show();
    }

}
