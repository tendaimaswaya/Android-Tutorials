package zw.co.recyclerview_json_retrofit

import android.os.Bundle
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import zw.co.recyclerview_json_retrofit.app.RetrofitProvider
import zw.co.recyclerview_json_retrofit.base.BaseActivity
import zw.co.recyclerview_json_retrofit.data.ClickListener
import zw.co.recyclerview_json_retrofit.data.ResponseListener
import zw.co.recyclerview_json_retrofit.data.adapter.ProductAdapter
import zw.co.recyclerview_json_retrofit.data.model.Product

class MainActivity : BaseActivity(), ClickListener, ResponseListener {
    override fun <T> onSuccess(data: T) {
        val listOfProducts = data as ArrayList<Product> //dont forget to type cast this
        observer.onNext(listOfProducts)
    }

    override fun onFail(reason: String) {
       alert(reason)
    }

    override fun <T> onClick(model: T) {
        val product = model as Product
        alert("You clicked: " +product.product)
    }

    val observer: Subject<ArrayList<Product>> = PublishSubject.create()
    lateinit var subscribe: Disposable

    private var list:ArrayList<Product> = ArrayList()
    private var adapter = ProductAdapter(this)

    companion object{
        lateinit var onResponseListener: ResponseListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onResponseListener = this
        recycler_view.initRecyclerview().adapter = adapter
        initObservable()
        loadContent()
    }

    fun initObservable(){
        subscribe = observer.map { adapter.setDataSource(it) } .subscribe{ adapter.notifyDataSetChanged() }
    }
    fun loadContent(){
        val client = RetrofitProvider.provideAPI()
        val call: Call<ArrayList<Product>> = client.getProducts()
        call.enqueue(object : Callback<ArrayList<Product>> {
            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {
                call.cancel()
                onResponseListener.onFail(t.localizedMessage)
            }
            override fun onResponse(
                call: Call<ArrayList<Product>>,
                response: Response<ArrayList<Product>>
            ) {
                list.clear()
                list = response.body()!!
                onResponseListener.onSuccess(list)
            }
        })
    }
}
