package com.example.pokegit.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokegit.R
import com.example.pokegit.data.model.PokeProvider
import com.example.pokegit.databinding.ActivityMainBinding
import com.example.pokegit.ui.recycler.PokeAdapter
import com.example.pokegit.ui.viewmodel.PokeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val pokeViewModel: PokeViewModel by viewModels()
    private lateinit var pokeAdapter: PokeAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private var offset = 0
    private var limit = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pokeViewModel.onCreate()

        layoutManager = LinearLayoutManager(this)
        binding.rvPokemones.layoutManager = layoutManager

        pokeViewModel.pokeLiveData.observe(this, Observer { pokemonList ->
            pokeAdapter.addPokemon(pokemonList)
        })

        initUI()
        setButtonLoad()
    }

    private fun setButtonLoad() {
        binding.btnLoad.setOnClickListener {
            limit += 20
            pokeViewModel.onCreateMore(offset, limit)
        }
    }

    private fun initUI() {
        GridLayoutManager(this, 3, RecyclerView.VERTICAL, false)
            .apply { binding.rvPokemones.layoutManager = this }

        pokeAdapter = PokeAdapter(PokeProvider.pokemonList)
        binding.rvPokemones.adapter = pokeAdapter
    }
}