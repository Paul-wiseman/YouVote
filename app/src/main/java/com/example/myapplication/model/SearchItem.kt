package com.example.myapplication.model

import com.example.myapplication.abstration.LocalModel

class SearchItem(
    val names: String,
    val position: String,
    val percentageScore: String,
    var image: String,
    val percentageScorePlaceHolder: String,
) : LocalModel