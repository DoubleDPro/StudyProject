package com.example.studyproject.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.studyproject.R
import com.example.studyproject.adapters.CitiesRecyclerAdapter
import com.example.studyproject.models.City

class MainActivity : AppCompatActivity() {

    var citiesArray: MutableList<City> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        initRecycler()
    }

    private fun initList() {
        citiesArray.add(City("Moscow"))
        citiesArray.add(City("Washington"))
        citiesArray.add(City("London"))
        citiesArray.add(City("Berlin"))
        citiesArray.add(City("Kiev"))
        citiesArray.add(City("Minsk"))
        citiesArray.add(City("Amsterdam"))
        citiesArray.add(City("Paris"))
        citiesArray.add(City("Prague"))
        citiesArray.add(City("Beijing"))
    }

    private fun initRecycler() {
        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        val adapter = CitiesRecyclerAdapter(this, citiesArray)
        recyclerView.adapter = adapter
    }
}