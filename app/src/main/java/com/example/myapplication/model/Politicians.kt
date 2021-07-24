package com.example.myapplication.model

data class Politicians(
    val names: String,
    val position: String,
    val percentageScore: String,
    var image: String,
    val percentageScorePlaceHolder: String,
) {
    override fun toString(): String {
        return "Legislations(names='$names', position='$position', image='$image', percentageScore= '$percentageScore', percentageScorePlaceHolder='$percentageScorePlaceHolder')"
    }
}