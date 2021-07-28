package com.example.myapplication.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.abstration.LocalModel
import com.example.myapplication.listeners.ResultsListener
import com.example.myapplication.tools.DiffUtilClass

class ResultsAdapter(val callback: ResultsListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ResultsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(viewType, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        Log.d(TAG, "onBindViewHolder: called.");
        when (holder) {

            is PoliticianAdapter.PoliticianViewHolder -> {
//                holder.bind(items.get(position))
            }


        }
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}

class ResultsViewHolder
constructor(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
}