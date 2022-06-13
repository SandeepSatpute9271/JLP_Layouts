package com.app.jlp_layouts.utils;/*
 * Created by Sandeep(Techno Learning) on 13,June,2022
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.app.jlp_layouts.R;

public class Utils {

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog mDialog = new ProgressDialog(context); // , R.style.AppTheme_AlertDialog
        mDialog.setMessage("Loading...");
        mDialog.setCancelable(false);
        mDialog.show();
        return mDialog;
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
