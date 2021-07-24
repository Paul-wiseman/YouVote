package com.example.myapplication

import android.content.Context
import android.preference.PreferenceManager
import androidx.preference.PreferenceManager
import com.example.myapplication.model.Politicians
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

private const val GROCERIES_LIST = "groceries_list"

fun saveGroceriesList(context: Context, list: List<Politicians>) {
    val json = Gson().toJson(list)

    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    sharedPreferences.edit().putString(GROCERIES_LIST, json).apply()
}

fun getGroceriesList(context: Context): List<Politicians> {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    val json = sharedPreferences.getString(GROCERIES_LIST, "")

    if (json.isNullOrEmpty()) {
        return listOf(Politicians(0, context.getString(R.string.item_default), System.currentTimeMillis()))
    }

    val type = object : TypeToken<ArrayList<Item>>() {}.type
    return Gson().fromJson(json, type)
}