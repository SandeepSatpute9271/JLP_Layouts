package com.app.jlp_layouts.ui.activities;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.app.jlp_layouts.presenter.BasePresenter;
import com.app.jlp_layouts.view.BaseView;

public abstract class BaseActivity<Presenter extends BasePresenter> extends AppCompatActivity implements BaseView {

    protected Presenter presenter;
    protected final String TAG = getClass().getSimpleName();

    @NonNull
    protected abstract Presenter createPresenter();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    public void showToast(String text) {
        if (text == null || text.isEmpty()) return;
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    public void showToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_LONG).show();
    }

    public void showShortToast(int resId) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
