package zw.co.recyclerview_json_retrofit.app

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import zw.co.recyclerview_json_retrofit.data.model.Product

interface Endpoint{
    /*   you can place custom headers here
        @Headers(
            "Content-Type: application/json",
            "Accept: application/json"
        )*/

    @POST("products/")
    fun getProducts(): Call<ArrayList<Product>>
}
class RetrofitProvider {
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