package com.example.pokegit.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pokegit.databinding.ItemPokemonBinding
import com.squareup.picasso.Picasso

class PokeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = ItemPokemonBinding.bind(view)

    fun bind(num: Int){
        Picasso.get()
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${num}.png")
            .into(binding.ivPokeItem)
    }
}