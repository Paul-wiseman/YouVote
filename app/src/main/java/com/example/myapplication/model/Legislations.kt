package com.example.myapplication.model

data class Legislations(

    var name: String,

    var position: String,

    var image: String,

    var score: String, // Author of blog post

    var party: String


) {

    override fun toString(): String {
        return "Legislations(name='$name', position='$position', image='$image', score= '$score', party='$party')"
    }


}