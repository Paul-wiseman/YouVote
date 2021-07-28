package com.example.myapplication.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.DataSource
import com.example.myapplication.R
import com.example.myapplication.adapters.PoliticianAdapter
import com.example.myapplication.model.Politicians
import com.example.utils.RecyclerViewClickListener
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {

    private  var politiciansAdapter = PoliticianAdapter(this)
    private lateinit var searchView: AutoCompleteTextView
    private var dataSource: ArrayList<Politicians> = DataSource.createDataSet()

//    private val searchAppPopUp = SearchAppPopUp()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // referencing recyclerview from the layout file
       val topResultRecyclerview = findViewById<RecyclerView>(R.id.main_activity_searchResultsRecView)

        searchView = findViewById(R.id.main_activity_searchView)




        // Related result recyclerview
//        relatedRecyclerView.layoutManager = LinearLayoutManager(this)
//        relatedRecyclerView.adapter = relatedResultAdapter

        // top result recyclerview
         topResultRecyclerview.adapter = politiciansAdapter
        topResultRecyclerview.layoutManager = LinearLayoutManager(this)


        /**
         * when the user inputs letters on the search view a list names matching the letters inputed
         * is displayed as suggestion
         */
        val arrayList = dataSource.map { it.names }
        val searchSugestionAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        searchView.setAdapter(searchSugestionAdapter)

        /**
         * when the user clicks on any suggested name a politician matching the result is displayed
         * other politicians are also displayed below the exact search
         */
        searchView.setOnItemClickListener { parent, view, position, id ->
            val text = parent[position] as? TextView

           val filetered =  dataSource.filter { it.names == text?.text }
            politiciansAdapter.setupFilteredList(filetered)
            politiciansAdapter.notifyDataSetChanged()

        }


//        findViewById<SearchView>(R.id.main_activity_searchView).post {
//
//            main_activity_searchView.setOnClickListener {
//                searchAppPopUp.showStatePopUp(main_activity_searchView) {
//                }
//            }
//        }

        initRecyclerView()
        addDataSet()
    }

    private fun filterQuery(newText: String?) {

        val searchResult: List<Politicians> =
            dataSource.filter { it.names.toLowerCase().contains(newText.toString().toLowerCase()) }
        politiciansAdapter.setupFilteredList(searchResult)
    }

    private fun addDataSet() {
        val data = DataSource.createDataSet()
        politiciansAdapter.submitList(data)
    }

    private fun initRecyclerView() {
        main_activity_searchResultsRecView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            politiciansAdapter = politiciansAdapter
            adapter = politiciansAdapter
        }
    }

    fun onInfoIcon(view: View) {
        InfoDialog().show(supportFragmentManager, "InfoAllyScore")
    }

    /**
     * recyclerview click listener implementation
     * on clicking any item in the recyclerview [OfficialsActivity::class] is started
     * @param politicians the politician object at the position of click
     * gson converter is used to convert the [Politicians] object to a parcelable
     */
    override fun itemClick(politicians: Politicians) {

        val gson = Gson()
        val intent = Intent(this, OfficialsActivity::class.java)
        intent.putExtra("identifier", gson.toJson(politicians))
        startActivity(intent)
    }

}
























