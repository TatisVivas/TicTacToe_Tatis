package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.Spinner
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adapter
        //Actividades
        binding.ticTacToe.setOnClickListener {
            startActivity(Intent(baseContext, TicTacToeActivity::class.java))
        }

        binding.randomGreet.setOnClickListener {
            val seleccion = binding.spinner.selectedItem.toString()
            val intent = Intent(baseContext, RandomGreetActivity::class.java)
            intent.putExtra("seleccion", seleccion) //pasar de una actividad a otra
            startActivity(intent)
        }
        binding.countries.setOnClickListener {
            startActivity(Intent(baseContext, CountriesActivity::class.java))
        }


    }

}