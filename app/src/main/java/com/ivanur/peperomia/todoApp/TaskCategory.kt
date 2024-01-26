package com.ivanur.peperomia.todoApp

sealed class TaskCategory(var isSelected: Boolean = true) {
    // una variable (isSelected) para todos los object
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Other: TaskCategory()
}