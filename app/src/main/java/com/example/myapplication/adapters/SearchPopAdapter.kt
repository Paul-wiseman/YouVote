//package com.example.myapplication.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.databinding.SearchPopupAdapterLayoutBinding
//import com.example.myapplication.tools.Callback
//
//class SearchPopAdapter : RecyclerView.Adapter<SearchPopAdapter.ViewHolder>() {
//    private var clickListener: Callback<String>? = null
//
//    private var itemList = emptyList<String>()
//
//    inner class ViewHolder(val binding: SearchPopupAdapterLayoutBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(value: String) {
//            binding.apply {
//                this.searchPopupTextView.text = value
//            }
//        }
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(
//            SearchPopupAdapterLayoutBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//
//    override fun getItemCount(): Int {
//        return itemList.size
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val currentItem = itemList[position]
//        holder.itemView.apply {
//            setOnClickListener {
//                clickListener?.invoke(currentItem)
//            }
//        }
//
//        holder.apply {
//            bind(currentItem)
//        }
//    }
//
//    fun setupItemList(list: List<String>) {
//        itemList = list
//        notifyDataSetChanged()
//    }
//
//    fun setClickListener(listener: Callback<String>) {
//        this.clickListener = listener
//    }
//}