package com.example.myapplication.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.model.Legislations
import com.example.myapplication.model.Politicians

class PoliticianAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG: String = "AppDebug"

    private var items: List<Politicians> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PoliticianViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {

            is LegislationAdapter.BlogViewHolder -> {
                holder.bind(items.get(position))
            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class PoliticianViewHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val politicians_image = itemView.blog_image
        val _title = itemView.blog_title
        val blog_author = itemView.blog_author

        fun bind(blogPost: BlogPost) {

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blog_image)
            blog_title.setText(blogPost.title)
            blog_author.setText(blogPost.username)

        }

    }
}