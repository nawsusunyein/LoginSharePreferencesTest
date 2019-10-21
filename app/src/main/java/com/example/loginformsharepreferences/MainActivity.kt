package com.example.loginformsharepreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import com.example.loginformsharepreferences.PreferencesHelper.defaultPreference
import com.example.loginformsharepreferences.PreferencesHelper.password
import com.example.loginformsharepreferences.PreferencesHelper.userId
import com.example.loginformsharepreferences.PreferencesHelper.clearValues
import com.example.loginformsharepreferences.PreferencesHelper.customPreference

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
        val prefs = customPreference(this,CUSTOM_PREF_NAME)
        when(v?.id){
            R.id.btn_save_user_data -> {
                prefs.userId = txt_user_id.text.toString().toInt()
                prefs.password = txt_password.text.toString()
            }

            R.id.btn_show -> {
                txt_user_id.setText(prefs.userId.toString())
                txt_password.setText(prefs.password)
            }

            R.id.btn_clear_user_data -> {
                prefs.clearValues
            }

            R.id.btn_show_default_user -> {
                val defaultPrefs = defaultPreference(this)
                txt_user_id.setText(defaultPrefs.userId.toString())
                txt_password.setText(defaultPrefs.password)
            }
        }
    }
}

object PreferencesHelper{
    val USER_ID = "USER_ID"
    val PASSWORD = "PASSWORD"

    fun defaultPreference(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun customPreference(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.userId
    get() = getInt("USER_ID",0)
    set(value) {
        editMe {
            it.putInt("USER_ID",value)
        }
    }

    var SharedPreferences.password
    get() = getString("PASSWORD","")
    set(value) {
        editMe {
            it.putString("PASSWORD",value)
        }
    }

    var SharedPreferences.clearValues
    get() = {}
    set(value) {
        editMe {
            it.clear()
        }
    }
}
