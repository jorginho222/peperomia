package com.ivanur.peperomia.apiExample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ivanur.peperomia.R

class FamilyAdapter(val families: List<FamilyItem>): RecyclerView.Adapter<FamilyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FamilyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FamilyViewHolder(layoutInflater.inflate(R.layout.item_family, parent, false))
    }

    override fun getItemCount(): Int = families.size

    override fun onBindViewHolder(holder: FamilyViewHolder, position: Int) {
        val family = families[position]
        holder.bind(family)
    }
}