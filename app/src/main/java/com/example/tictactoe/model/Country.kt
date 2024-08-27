package com.example.tictactoe.model

class Country() {
    var nombre: String = ""
    var capital: String = ""
    var nombre_int: String = ""
    var sigla: String = ""

    constructor(nombre: String, capital: String, nombre_int: String, sigla: String) : this() {
        this.nombre = nombre
        this.capital = capital
        this.nombre_int = nombre_int
        this.sigla = sigla
    }

    override fun toString(): String {
        return nombre
    }
}
