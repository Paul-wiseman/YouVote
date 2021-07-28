package com.example.myapplication.data

import com.example.myapplication.model.Politicians


class DataSource {

    companion object {

        fun createDataSet(): ArrayList<Politicians> {
            val list = ArrayList<Politicians>()
            list.add(
                Politicians(
                    "Kamala Harris!",
                    "Senator(D)",
                    "90%",
                    "https://raw.githubusercontent.com/odogwudev/UYK/main/kamala%203.png",
                    "Ally Score"
                )
            )
            list.add(
                Politicians(
                    "Ami Bera!",
                    "Representative(D)",
                    "70%",
                    "https://raw.githubusercontent.com/odogwudev/UYK/main/amibera.jpg",
                    "Ally Score"
                )
            )
            list.add(
                Politicians(
                    "Diane Feinstein!",
                    "Representative(D)",
                    "65%",
                    "https://raw.githubusercontent.com/odogwudev/UYK/main/diane.jpeg",
                    "Ally Score"
                )
            )
            list.add(
                Politicians(
                    "Barrack Obama!",
                    "Pres.Candidate (D)",
                    "90%",
                    "https://raw.githubusercontent.com/odogwudev/UYK/main/obama.jpeg",
                    "Ally Score"
                )
            )
            list.add(
                Politicians(
                    "Joe Biden!",
                    "Pres. Candidate (D)",
                    "90%",
                    "https://raw.githubusercontent.com/odogwudev/UYK/main/joebiden.jpg",
                    "Ally Score"
                )
            )
            return list
        }
    }
}