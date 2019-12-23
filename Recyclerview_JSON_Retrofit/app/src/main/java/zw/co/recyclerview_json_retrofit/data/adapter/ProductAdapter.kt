package zw.co.recyclerview_json_retrofit.data.adapter

import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import zw.co.recyclerview_json_retrofit.R
import zw.co.recyclerview_json_retrofit.data.ClickListener
import zw.co.recyclerview_json_retrofit.data.model.Product
import zw.co.recyclerview_json_retrofit.util.CircleTransform

class ProductAdapter (var listener: ClickListener) : RecyclerView.Adapter<ProductAdapter.NewsViewHolder>() {

    private var mDataSource: List<Product>? = null

    fun setDataSource(dataSource: List<Product>) {
        this.mDataSource = dataSource
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val productItem = mDataSource!![position]
        holder.bind(productItem, listener)
    }

    override fun getItemCount(): Int {
        return mDataSource?.size ?: 0
    }

    class NewsViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var productItem: Product? = null

        private val product: TextView? by lazy {
            itemView.findViewById(R.id.product) as TextView?
        }
        private val datePosted: TextView? by lazy {
            itemView.findViewById(R.id.date_posted) as TextView?
        }
        private val coverImage: ImageView? by lazy {
            itemView.findViewById(R.id.icon) as ImageView?
        }
        private val doneLoadingIcon: ImageView? by lazy {
            itemView.findViewById(R.id.doneLoading) as ImageView?
        }
        private val container: RelativeLayout? by lazy {
            itemView.findViewById(R.id.container) as RelativeLayout?
        }


        fun bind(productItem: Product, listener: ClickListener) {

            this.productItem = productItem
            product!!.text = productItem.product
            datePosted!!.text = productItem.datePosted

            container?.setOnClickListener {
                listener.onClick(productItem)
            }

            if (!TextUtils.isEmpty(productItem.image)) {
                Picasso.get()
                    .load(productItem.image)
                    .placeholder(R.drawable.placeholder_grey)
                    .transform(CircleTransform())
                    .centerCrop()
                    .fit() //life saver to stop images from reloading when they are about to be displayed
                    .into(coverImage , object : Callback {
                        override fun onSuccess() {
                            //do something you want for example:
                            doneLoadingIcon!!.visibility = View.VISIBLE
                        }
                        override fun onError(e: Exception) {
                            //do something you want for example:
                            doneLoadingIcon!!.visibility = View.GONE
                        }

                    })
            }
        }
    }

}