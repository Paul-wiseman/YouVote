package com.example.myapplication.tools

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.abstration.LocalModel

class DiffUtilClass<T : LocalModel> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.equals(newItem)
    }
}