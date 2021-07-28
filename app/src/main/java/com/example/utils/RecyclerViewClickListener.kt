package com.example.utils

import com.example.myapplication.model.Politicians

interface RecyclerViewClickListener {
    fun itemClick(politicians: Politicians)
}