package com.hfad.beeradviser

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.find_beer).setOnClickListener{
            val beer_color = findViewById<Spinner>(R.id.beer_color)
            val color = beer_color.selectedItem.toString()
            val beerList=getBeers(color)
            val beer = beerList.reduce{acc,s->acc+'\n'+s}
            val brands = findViewById<TextView>(R.id.brands)
            brands.text = beer
        }
    }
    fun getBeers(color:String):List<String>{
        return when (color){
            "Light"->listOf("Jail Pale Ale", "Lager Lite")
            "Amber"->listOf("Jack Amber", "Red Moose")
            "Brown"->listOf("Brown Bear Beer", "Bock Brownie")
            else->listOf("Gout Stout", "Dark Daniel")
        }
    }
}