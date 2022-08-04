package com.example.pokegit.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokegit.R
import com.example.pokegit.data.model.Pokemon

class PokeAdapter(var pokeList: List<Pokemon>): RecyclerView.Adapter<PokeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        return PokeViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        var foto = pokeList[position].getNum()
        holder.bind(foto)
    }

    override fun getItemCount(): Int = pokeList.size
}