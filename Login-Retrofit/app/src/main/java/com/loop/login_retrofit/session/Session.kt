package com.loop.login_retrofit.session

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.loop.login_retrofit.model.User


class Session(context: Context) {
    var pref: SharedPreferences
    internal var editor: SharedPreferences.Editor
    internal var _context: Context
    internal var PRIVATE_MODE = 0
    private val PREF_NAME = "CassavaRemit"
    init {
        _context = context
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
    // LogCat tag
    private val TAG = Session::class.java.simpleName

    private val KEY_USER = "userDetails"

    fun setUser(user: String?) {
        editor.putString(KEY_USER, user)
        editor.commit()
    }

    fun getUser(): String? {
        return pref.getString(KEY_USER, null)
    }

    fun getUserJSON(): User?{
        return Gson().fromJson( pref.getString(KEY_USER, null), User::class.java)
    }

}