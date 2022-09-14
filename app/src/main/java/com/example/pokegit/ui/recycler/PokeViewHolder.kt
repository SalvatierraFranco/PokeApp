package com.example.pokegit.ui.recycler

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.data.model.PokeProvider
import com.example.pokegit.databinding.ItemPokemonBinding
import com.example.pokegit.ui.view.PokeInfoActivity
import com.squareup.picasso.Picasso

class PokeViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var binding = ItemPokemonBinding.bind(view)

    fun bind(num: Int, nombre: String){
        Picasso.get()
            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${num}.png")
            .into(binding.ivPokeItem)

        binding.tvNamePokemon.text = nombre.uppercase()
    }

    init {
        view.setOnClickListener { v ->
            var position = adapterPosition
            var intent = Intent(v.context, PokeInfoActivity::class.java).apply {
                putExtra("frontPic", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position+1}.png")
                putExtra("id", position+1)
                putExtra("url", PokeProvider.pokemonList[position].url)
            }
            startActivity(v.context, intent, null)
        }

    }
}