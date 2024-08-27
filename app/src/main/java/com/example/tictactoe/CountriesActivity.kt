package com.example.tictactoe

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityCountriesBinding
import com.example.tictactoe.model.Country
import org.json.JSONObject

class CountriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCountriesBinding
    var countries = mutableListOf<Country>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCountriesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCountries()
        val adapter = ArrayAdapter<Country>(this, R.layout.simple_list_item_1, countries)
        binding.listCountries.adapter = adapter
        binding.listCountries.setOnItemClickListener { parent, view, position, id ->
            val queryCountry = countries[position]
            val intent = Intent(baseContext, InformationCountryActivity::class.java)
            intent.putExtra("nombre",queryCountry.nombre)
            intent.putExtra("capital", queryCountry.capital)
            intent.putExtra("nombre_int", queryCountry.nombre_int)
            intent.putExtra("sigla", queryCountry.sigla)
            startActivity(intent)

        }
    }

    private fun loadCountries() {
        val json_string = this.assets.open("paises.json").bufferedReader().use { it.readText() }
        val json = JSONObject(json_string)
        val paisesJsonArray = json.getJSONArray("paises")
        for (i in 0 until paisesJsonArray.length()) {
            val jsonObject = paisesJsonArray.getJSONObject(i)
            val capital = jsonObject.getString("capital")
            val name = jsonObject.getString("nombre_pais")
            val sigla = jsonObject.getString("sigla")
            val nombre_pais_int = jsonObject.getString("nombre_pais_int")

            // Crear el objeto pais y agregarlo al arreglo
            val country = Country(name, capital, nombre_pais_int, sigla)
            countries.add(country)
        }
    }
}