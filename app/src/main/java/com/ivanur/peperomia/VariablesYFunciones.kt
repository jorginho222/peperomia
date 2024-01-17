package com.ivanur.peperomia

fun main() {
    variablesNumericas()

    // soporta un solo caracter
    val char: Char = '%'

    val string: String = "Tamales *#@~"

    val isTruth: Boolean = true

    val conca: String = "$char $string"

    val llamadaOk: String = llamarCelu("1112223")
}

fun variablesNumericas() {
    // valores (val), no pueden ser reasignados
    val age: Int = 5

    var age2: Int = 7
    age2 = 8

    // long para almacenar val mas grandes
    val stolen: Long = 30

    val peso: Float = 1.5f

    // double para mas decimales
    val variablePi: Double = 3.1415

    val ageTotal = age2 % age

    var oper = variablePi + age

    println(oper)
}

fun llamarCelu(num: String) = "llamando... $num"