package com.app.jlp_layouts.presenter;/*
 * Created by Sandeep(Techno Learning) on 10,June,2022
 */

import com.app.jlp_layouts.view.BaseView;

public abstract class BasePresenter<View extends BaseView> {

    protected View view;

    protected BasePresenter(View view) {
        this.view = view;
    }

    public void onDetach() {
        view = null; //avoid memory leak
    }
}
