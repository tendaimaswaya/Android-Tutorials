package com.loop.login_retrofit

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import com.loop.login_retrofit.base.BaseActivity
import kotlinx.android.synthetic.main.activity_logged_in.*

class LoggedInActivity : BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)
        user_details.text =  "Hi, ".plus(session.getUserJSON()!!.userName)
    }

    fun logout(view: View){  //invoked from the layout - onclick
        session.setUser(null) //remove user set preferences
        this.finish()
        openActivity(LoginActivity())
    }
}