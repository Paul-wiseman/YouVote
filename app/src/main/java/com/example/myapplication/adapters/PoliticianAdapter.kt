package com.example.myapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.R
import com.example.myapplication.model.Politicians
import com.example.utils.RecyclerViewClickListener
import kotlinx.android.synthetic.main.layout_list_item.view.*

class PoliticianAdapter(var listener: RecyclerViewClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TAG = "RecyclerViewAdapter"


    private var items: List<Politicians> = ArrayList()
//    private var filterList = emptyList<Politicians>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PoliticianViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d(TAG, "onBindViewHolder: called.");
        when (holder) {
            is PoliticianViewHolder -> {
                holder.bind(items.get(position))
                holder.itemView.setOnClickListener {
                   val clickedPolitician: Politicians =  items[position]
                    listener.itemClick(clickedPolitician)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(politiciansList: List<Politicians>) {
        items = politiciansList
    }

    class PoliticianViewHolder
    constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        val politicians_image = itemView.img_item
        val politicalName = itemView.politicalName
        val poloiticalpercentageScore = itemView.poloiticalpercentageScore
        val politicalAllyScire = itemView.politicalAllyScire
        val politicalPosition = itemView.politicalPosition

        fun bind(politicians: Politicians) {

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(politicians.image)
                .into(politicians_image)
            politicalName.setText(politicians.names)
            politicalPosition.setText(politicians.position)
            poloiticalpercentageScore.setText(politicians.percentageScore)
            politicalAllyScire.setText(politicians.percentageScorePlaceHolder)

        }
    }

   fun setupFilteredList(list: List<Politicians>){
       items = list
   }

}