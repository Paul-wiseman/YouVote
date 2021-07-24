package com.example.myapplication

import com.example.myapplication.model.Politicians


class DataSource {

    companion object {

        fun createDataSet(): ArrayList<Politicians> {
            val list = ArrayList<Politicians>()
            list.add(
                Politicians(
                    "Kamala Harris!",
                    "Senator(D)",
                    "https://raw.githubusercontent.com/odogwudev/UYK/main/harris.jpeg",
                    "80%",
                    "D"
                )
            )
            return list
        }
    }
}