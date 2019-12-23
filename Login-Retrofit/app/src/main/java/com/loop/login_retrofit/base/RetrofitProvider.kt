package com.loop.login_retrofit.base

import com.loop.login_retrofit.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface Endpoint{
/*   you can place custom headers here
    @Headers(
        "Content-Type: application/json",
        "Accept: application/json"
    )*/
    @FormUrlEncoded
    @POST("login/")
    fun login(@Field("id") id: String,
              @Field("password") password: String): Call<User>
}
class RetrofitBase {
    companion object {
        internal fun provideAPI(): Endpoint {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://tutorialsapi.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(Endpoint::class.java)
        }
    }
}