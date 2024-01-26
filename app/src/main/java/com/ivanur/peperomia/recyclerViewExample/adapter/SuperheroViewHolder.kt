package com.ivanur.peperomia.recyclerViewExample.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivanur.peperomia.R
import com.ivanur.peperomia.recyclerViewExample.Superhero

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val superheroName = view.findViewById<TextView>(R.id.tvSuperheroName)
    val realName = view.findViewById<TextView>(R.id.tvRealName)
    val publisher = view.findViewById<TextView>(R.id.tvPublisher)
    val photo = view.findViewById<ImageView>(R.id.ivSuperhero)

    fun render(superheroModel: Superhero) {
        superheroName.text = superheroModel.superhero
        realName.text = superheroModel.realName
        publisher.text = superheroModel.publisher
    }
}