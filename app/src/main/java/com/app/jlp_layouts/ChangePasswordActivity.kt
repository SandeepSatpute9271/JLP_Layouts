package com.app.jlp_layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager




class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        supportActionBar?.hide();
    }
}