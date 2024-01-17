package com.ivanur.peperomia.someConcepts

fun main() {
    var name: String? = "null"

    // con !! estoy seguro q va a tener un valor.
//    println(name!![3])

    // no se con certeza q tiene un valor
    println(name?.get(3) ?: "Es nulo")
}