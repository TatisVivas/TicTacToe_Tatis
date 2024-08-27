package com.example.tictactoe

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityInformationCountryBinding

class InformationCountryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInformationCountryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cambiarTextos()
    }

    private fun cambiarTextos() {

        val nombrePais = intent.getStringExtra("nombre")
        val capital = intent.getStringExtra("capital")
        val nombreInt = intent.getStringExtra("nombre_int")
        val sigla = intent.getStringExtra("sigla")

        binding.nombrePais.text = nombrePais
        binding.capitalPais.text = capital
        binding.nombreInt.text = nombreInt
        binding.siglaPais.text = sigla

        val country = mapOf(
            "Alemania" to R.drawable.alemania,
            "Argentina" to R.drawable.argentina,
            "Australia" to R.drawable.australia,
            "Austria" to R.drawable.austria,
            "Bélgica" to R.drawable.belgica,
            "Bolívia" to R.drawable.bolivia,
            "Brasil" to R.drawable.brasil,
            "Chile" to R.drawable.chile,
            "Colombia" to R.drawable.colombia,
            "Cuba" to R.drawable.cuba,
            "Ecuador" to R.drawable.ecuador,
            "España" to R.drawable.espa_a,
            "Estados Unidos" to R.drawable.estados_unidos,
            "Francia" to R.drawable.francia,
            "Reino Unido" to R.drawable.reino_unido,
            "Grecia" to R.drawable.grecia,
            "Holanda" to R.drawable.holanda,
            "Hungria" to R.drawable.hungria,
            "Irlanda" to R.drawable.irlanda,
            "Islandia" to R.drawable.islandia,
            "Israel" to R.drawable.israel,
            "Italia" to R.drawable.italia,
            "Japón" to R.drawable.japon,
            "Uruguay" to R.drawable.uruguay,
            "Venezuela" to R.drawable.venezuela
        )
        binding.flag.setImageResource(country[nombrePais] ?: R.drawable.ic_launcher_background)

    }

}