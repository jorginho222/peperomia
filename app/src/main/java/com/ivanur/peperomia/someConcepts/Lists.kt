package com.ivanur.peperomia.someConcepts

fun main() {
    mutableList()
}

fun mutableList() {
    var weekDays: MutableList<String> = mutableListOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")
    println(weekDays)

    weekDays.add(0, "Osvaldo")
    println(weekDays)

    if (weekDays.isNotEmpty()) {
        weekDays.forEach { println(it) }
    }
}

fun inmutableList() {
    val readOnly: List<String> = listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

    println(readOnly.size)
    println(readOnly.last())
    println(readOnly.first())

    val example = readOnly.filter { it.contains("a") }
    println(example)

    // weekDay represents each element
    readOnly.forEach { weekDay -> println(weekDay) }
}