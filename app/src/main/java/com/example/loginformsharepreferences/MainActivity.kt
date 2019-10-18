package com.example.loginformsharepreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{


    val CUSTOM_PREF_NAME = "Login_Data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_save_user_data.setOnClickListener(this)
        btn_clear_user_data.setOnClickListener(this)
        btn_show.setOnClickListener(this)
        btn_show_default_user.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val prefs = c
    }
}

object 
