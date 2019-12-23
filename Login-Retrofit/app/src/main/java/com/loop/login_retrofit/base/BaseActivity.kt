package com.loop.login_retrofit.base

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.loop.login_retrofit.session.Session

open class BaseActivity :AppCompatActivity(){
    fun openActivity(targetClass: Activity){
        startActivity(Intent(this, targetClass::class.java))
    }
    fun <T> alert(msg:T,defaultLength:Int = Toast.LENGTH_LONG){
        Toast.makeText(this,msg.toString(),defaultLength).show()
    }

    protected val session by lazy {
        return@lazy Session(this)
    }

    fun retrofitClient():Endpoint{
        return RetrofitBase.provideAPI()
    }
}
