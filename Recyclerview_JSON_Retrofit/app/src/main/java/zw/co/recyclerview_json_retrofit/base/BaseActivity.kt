package zw.co.recyclerview_json_retrofit.base

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast

open class BaseActivity:AppCompatActivity() {

    fun <T> alert(msg:T, defaultLength:Int = Toast.LENGTH_LONG){
        Toast.makeText(this, msg.toString(), defaultLength).show()
    }

    fun RecyclerView.initRecyclerview():RecyclerView{
        val mLayoutManager = LinearLayoutManager(context)
        setLayoutManager(mLayoutManager)
        setItemAnimator(DefaultItemAnimator())
        return this
    }
}