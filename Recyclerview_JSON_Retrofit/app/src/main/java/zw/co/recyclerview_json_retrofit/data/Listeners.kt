package zw.co.recyclerview_json_retrofit.data

interface ClickListener {
    fun <T> onClick(model:T)
}

interface ResponseListener{
    fun <T> onSuccess(data: T)
    fun onFail(reason:String)
}