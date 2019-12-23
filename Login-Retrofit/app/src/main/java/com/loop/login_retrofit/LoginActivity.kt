package com.loop.login_retrofit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.loop.login_retrofit.base.BaseActivity
import com.loop.login_retrofit.model.User
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if(session.getUser()!=null){
            openActivity(LoggedInActivity())
            this.finish()
        }
    }

    fun login(view: View){ //this is called from activity_login.xml - view is not used but is required, remove it and onclick, app will crash
        if(id_et.text.isNotEmpty() && pass_et.text.isNotEmpty()) initLogin(id_et.text.toString().trim(), pass_et.text.toString().trim())
        else alert("Fill in missing fields")
    }

    fun startLoggingIn(){
        alert("Processing", defaultLength = Toast.LENGTH_SHORT)
        id_et.isEnabled = false
        pass_et.isEnabled = false
    }

    fun stopLoggingIn(){
        id_et.isEnabled = true
        pass_et.isEnabled = true
    }


    fun initLogin(id:String,password:String){
        startLoggingIn()

        val call: Call<User> = retrofitClient().login(id,password)
        call.enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                call.cancel()
                alert("Failed-> Reason -: " + t.localizedMessage!!)
                stopLoggingIn()
            }
            override fun onResponse(
                call: Call<User>,
                response: Response<User>
            ) {
                stopLoggingIn()

                /*this construct depends on your JSON response - according to the one we are using, this will loosely suffice - checking if response body is NOT null
                also you might wanna use an interface to handle UI responses as opposed to handling them in the network call but no biggie here */
                if(response.isSuccessful && response.body()!=null) {
                    val res = response.body() as User //res.access
                    val user =  Gson().toJson(res,User::class.java)
                    session.setUser(user)
                    openActivity(LoggedInActivity())
                    finish()

                }else { alert("User not found")  }
            }
        })
    }


}
