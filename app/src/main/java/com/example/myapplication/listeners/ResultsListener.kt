package com.example.myapplication.listeners

import com.example.myapplication.model.Politicians


interface ResultsListener {

    fun onPoliticiansResultsClick(politicians: Politicians)
}

