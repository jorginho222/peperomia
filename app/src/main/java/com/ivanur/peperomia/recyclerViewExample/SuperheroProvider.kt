package com.ivanur.peperomia.recyclerViewExample

class SuperheroProvider {
    companion object {
        val superherosList = listOf<Superhero>(
            Superhero(
                "KotlinMan",
                "Jetbrains",
                "Ivanur",
                "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
            ),
            Superhero(
                "Molero",
                "Telefe",
                "Marcos",
                "https://cursokotlin.com/wp-content/uploads/2017/07/daredevil.jpg"
            ),
            Superhero(
                "Archundia",
                "Telefe",
                "Miguel",
                "https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"
            ),
            Superhero(
                "Don quijote",
                "Alibaba",
                "Mancha",
                "https://cursokotlin.com/wp-content/uploads/2017/07/logan.jpeg"
            ),
        )

    }
}