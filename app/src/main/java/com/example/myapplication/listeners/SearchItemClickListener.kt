package com.example.myapplication.listeners

import com.example.myapplication.model.Query
import com.example.myapplication.model.SearchItem

class SearchItemClickListener {
    interface SearchItemClickListener {
        fun onQueryClick(query: Query)
        fun onSearchItemClick(searchItem: SearchItem)
    }
}