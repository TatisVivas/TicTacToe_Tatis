package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictactoe.databinding.ActivityMainBinding
import com.example.tictactoe.databinding.ActivityTicTacToeBinding

class TicTacToeActivity : AppCompatActivity() {
    //Crear un enum para los 2 tipos de jugadores
    enum class turno {
        EQUIS,
        CIRCULO
    }

    private var primerTurno = turno.EQUIS
    private var actualJugador = turno.EQUIS

    private var tablero = mutableListOf<Button>()

    private lateinit var binding: ActivityTicTacToeBinding //conecta el XML a través de binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTicTacToeBinding.inflate(layoutInflater) //inicializo el binding, no con R sino con binding
        setContentView(binding.root)
        tablero()
        binding.newGame.setOnClickListener {
            reiniciar()

        }

    }
    private fun actualizarTurno() {
        val turnoTexto = if (actualJugador == turno.EQUIS) "TURNO JUGADOR: X" else "TURNO JUGADOR: O"
        binding.turnoID.text = turnoTexto
    }

    //en mi lista de botones, agrego todos los botones que tengo en mi vista principal, lso nombro por posición como tablero de batalla naval para poder diferenciarlos en la revisión
    private fun tablero() {
        tablero.add(binding.a1)
        tablero.add(binding.a2)
        tablero.add(binding.a3)
        tablero.add(binding.b1)
        tablero.add(binding.b2)
        tablero.add(binding.b3)
        tablero.add(binding.c1)
        tablero.add(binding.c2)
        tablero.add(binding.c3)

        for(i in tablero){
            i.setOnClickListener {
                vista(it)
            }
        }


    }

    private fun vista(view: View) {
        val boton = view as Button
        if (boton.text.isEmpty()) {
            boton.text = if (actualJugador == turno.EQUIS) "X" else "O"
            if (revisarGanador(boton.text.toString())) {
                resultado("Ganador: ${boton.text}") //el actual jugador es el ganador
            } else if (empate()) {
                resultado("Empate")
            } else {
                actualJugador = if (actualJugador == turno.EQUIS) turno.CIRCULO else turno.EQUIS
                actualizarTurno()
            }
        }
    }

    private fun resultado(s: String) {
        //imrpimir el resultado en un toast
        Toast.makeText(baseContext, "$s", Toast.LENGTH_SHORT).show()//necesito el contexto
        deshabilitarBotones()
        Toast.makeText(baseContext, "CLICK ON 'NEW GAME' TO PLAY AGAIN", Toast.LENGTH_LONG).show()//necesito el contexto

    }

    //función para cuadno le hago clic se le asigne o X o O
    private fun clicBoton(boton: Button) {
        if (boton.text.isEmpty()) {
            if (actualJugador == turno.EQUIS) {
                boton.text = "X"
                //boton.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.teaGreen))
                boton.setBackgroundColor(Color.parseColor("#C1F7DC"))//Tea Green
                actualJugador = turno.CIRCULO
            } else {
                boton.text = "O"
                actualJugador = turno.EQUIS
                //boton.setBackgroundColor(ContextCompat.getColor(binding.root.context, R.color.munsell))
                boton.setBackgroundColor(Color.parseColor("#388697")) //munsell

            }
        } else
            return
    }

    //función para reiniciar el juego
    private fun reiniciar() {
        for(i in tablero){
            i.text = ""
            i.setBackgroundColor(Color.parseColor("#C0C5C1"))//Silver
            i.isEnabled = true

        }
        actualJugador = turno.EQUIS
        primerTurno = turno.EQUIS
        actualizarTurno()
    }
    private fun empate(): Boolean {
        for(i in tablero){
            if(i.text.isEmpty()){
                return false
            }

        }
        return true
    }
    private fun revisarGanador(s: String): Boolean {
        //revisar si hay un ganador
        //HORIZONTALES

        if(binding.a1.text == s && binding.a2.text == s && binding.a3.text == s){
            binding.a1.setBackgroundColor(Color.parseColor("#00FF00")) //green
            binding.a1.setTextColor(Color.parseColor("#FF000000"))//black
            binding.a2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a2.setTextColor(Color.parseColor("#FF000000"))
            binding.a3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a3.setTextColor(Color.parseColor("#FF000000"))


            return true
        }
        if(binding.b1.text == s && binding.b2.text == s && binding.b3.text == s){
            binding.b1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b1.setTextColor(Color.parseColor("#FF000000"))
            binding.b2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b2.setTextColor(Color.parseColor("#FF000000"))
            binding.b3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b3.setTextColor(Color.parseColor("#FF000000"))
            return true
        }
        if(binding.c1.text == s && binding.c2.text == s && binding.c3.text == s){
            binding.c1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c1.setTextColor(Color.parseColor("#FF000000"))
            binding.c2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c2.setTextColor(Color.parseColor("#FF000000"))
            binding.c3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c3.setTextColor(Color.parseColor("#FF000000"))
            return true
        }

        //VERTICALES
        if(binding.a1.text == s && binding.b1.text == s && binding.c1.text == s){
            binding.a1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a1.setTextColor(Color.parseColor("#FF000000"))
            binding.b1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b1.setTextColor(Color.parseColor("#FF000000"))
            binding.c1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c1.setTextColor(Color.parseColor("#FF000000"))
            return true
        }
        if(binding.a2.text == s && binding.b2.text == s && binding.c2.text == s){
            binding.a2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a2.setTextColor(Color.parseColor("#FF000000"))
            binding.b2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b2.setTextColor(Color.parseColor("#FF000000"))
            binding.c2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c2.setTextColor(Color.parseColor("#FF000000"))
            return true
        }
        if(binding.a3.text == s && binding.b3.text == s && binding.c3.text == s){
            binding.a3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a3.setTextColor(Color.parseColor("#FF000000"))
            binding.b3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b3.setTextColor(Color.parseColor("#FF000000"))
            binding.c3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c3.setTextColor(Color.parseColor("#FF000000"))
            return true
        }

        //DIAGONALES
        if(binding.a1.text == s && binding.b2.text == s && binding.c3.text == s){
            binding.a1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a1.setTextColor(Color.parseColor("#FF000000"))
            binding.b2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b2.setTextColor(Color.parseColor("#FF000000"))
            binding.c3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c3.setTextColor(Color.parseColor("#FF000000"))
            return true
        }
        if(binding.a3.text == s && binding.b2.text == s && binding.c1.text == s){
            binding.a3.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.a3.setTextColor(Color.parseColor("#FF000000"))
            binding.b2.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.b2.setTextColor(Color.parseColor("#FF000000"))
            binding.c1.setBackgroundColor(Color.parseColor("#00FF00"))
            binding.c1.setTextColor(Color.parseColor("#FF000000"))
            return true
        }

        return false

    }

    private fun deshabilitarBotones(){
        for(i in tablero){
            i.isEnabled = false
        }
    }

}