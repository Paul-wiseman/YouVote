package com.example.myapplication.model

import com.example.myapplication.abstration.LocalModel

class Query(
    var queryName: String
) : LocalModel {
    constructor() : this("")
}