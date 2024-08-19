package com.example.tictactoe

import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityRandomGreetBinding

class RandomGreetActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomGreetBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRandomGreetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val language = intent.getStringExtra("seleccion")
        val saludo= when (language) {
            "English" -> "Hello!"
            "Español" -> "¡Hola!"
            "Français" -> "Bonjour!"
            "Deutsch" -> "Hallo!"
            "Italiano" -> "Ciao!"
            else -> "Hello!"
        }

        binding.textView.text = saludo

        val imageMap = mapOf(
            "English" to R.drawable.english,
            "Español" to R.drawable.espanol,
            "Français" to R.drawable.fran_ais,
            "Deutsch" to R.drawable.deutsch,
            "Italiano" to R.drawable.italiano
        )
        val imageId = imageMap[language] ?: R.drawable.ic_launcher_background
        binding.imageView.setImageResource(imageId)

    }


}