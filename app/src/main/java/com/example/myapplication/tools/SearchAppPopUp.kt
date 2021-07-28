//package com.example.myapplication.tools
//
//import android.content.Context
//import android.os.Build
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup.*
//import android.widget.PopupWindow
//import android.widget.SearchView
//import androidx.annotation.RequiresApi
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.R
//import com.example.myapplication.adapters.SearchPopAdapter
//import com.example.myapplication.data.DataSource
//import com.example.myapplication.model.Politicians
//
//class SearchAppPopUp {
//
//    private var dataSource: ArrayList<Politicians> = DataSource.createDataSet()
//    private val searchPopAdapter = SearchPopAdapter()
//    var popupWindow: PopupWindow = PopupWindow()
//    private var adapter = SearchPopAdapter()
//    private lateinit var customView: View
//
////    init {
////        adapter.setupItemList(mutableListOf())
////    }
//
//    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
//    fun showStatePopUp(
//        searchView: SearchView, clickListener: Callback<String>,
//    ) {
//        val layoutInflater: LayoutInflater =
//            searchView.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//
//        customView = layoutInflater.inflate(R.layout.window_popup_layout, null)
//
//        val width = searchView.width
//        val searchableRecyclerView: RecyclerView =
//            customView.findViewById(R.id.search_pop_recycler_view)
//
//
//        searchableRecyclerView.adapter = adapter
//        searchItem(searchView)
////        searchPopAdapter.setupItemList(listOf("Gi", "po", "La"))
//
//        popupWindow = PopupWindow(customView, width, LayoutParams.WRAP_CONTENT, true)
//        popupWindow.elevation = 2F
//
//        popupWindow.showAsDropDown(searchView, 0, 20, 0)
//
//        adapter.setClickListener {
//            popupWindow.dismiss()
//            clickListener(it)
//        }
//    }
//    //When the popup is dismissed, empty the query so that when it's opened again, it starts from afresh
//    private fun searchItem(searchView: SearchView) {
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                filterQuery(newText)
//                return true
//            }
//
//            fun filterQuery(newText: String?) {
//                val searchResult = dataSource.filter {
//                    it.names.toLowerCase().contains(newText.toString().toLowerCase())
//                }.map { it.names }
//                searchPopAdapter.setupItemList(searchResult)
//                searchPopAdapter.notifyDataSetChanged()
//            }
//
//        })
//
//    }
//}

