package com.ivanur.peperomia.apiExample

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ivanur.peperomia.databinding.ItemFamilyBinding

class FamilyViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemFamilyBinding.bind(view)
    fun bind(family: FamilyItem) {
        binding.tvFamilyName.text = family.name
    }
}