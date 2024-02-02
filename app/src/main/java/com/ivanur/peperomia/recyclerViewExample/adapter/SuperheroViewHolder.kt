package com.ivanur.peperomia.recyclerViewExample.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ivanur.peperomia.databinding.ItemSuperheroBinding
import com.ivanur.peperomia.recyclerViewExample.Superhero

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //  para no estar seleccionando haciendo find by id. Iniciamos el binding y de ahi extraemos cada elemento (accediendo a la id de cada uno)
    val binding = ItemSuperheroBinding.bind(view)

    fun render(superheroModel: Superhero, onClickListener: (Superhero) -> Unit) {
        binding.tvSuperheroName.text = superheroModel.superhero
        binding.tvRealName.text = superheroModel.realName
        binding.tvPublisher.text = superheroModel.publisher
        // cargando la imagen a partir de la url con glide
        Glide.with(binding.ivSuperhero.context).load(superheroModel.photo).into(binding.ivSuperhero)

        itemView.setOnClickListener { onClickListener(superheroModel) }
    }
}