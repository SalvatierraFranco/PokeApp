package com.example.pokegit.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pokegit.R
import com.example.pokegit.data.model.PokeInfo
import com.example.pokegit.databinding.ActivityPokeInfoBinding
import com.example.pokegit.ui.viewmodel.PokeViewModel
import com.squareup.picasso.Picasso
import java.util.*

class PokeInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPokeInfoBinding
    private val PokeInfoViewModel: PokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundle()

        PokeInfoViewModel.pokeInfoLiveData.observe(this, androidx.lifecycle.Observer { currentPokemon ->
            setViews(currentPokemon)
        })
    }

    private fun getBundle() {
        var bundle = intent.extras
        var pokePic = bundle!!.getString("frontPic")
        var pokeId = bundle!!.getInt("id")

        Picasso.get().load(pokePic).into(binding.ivPokePic)

        PokeInfoViewModel.onCreatePokeInfo(pokeId)
    }

    private fun setViews(currentPokemon: PokeInfo?) {
        binding.tvName.text = currentPokemon!!.name.uppercase()
        binding.tvHeight.text = currentPokemon!!.height + "m (Altura)"
        binding.tvWeight.text = currentPokemon!!.weight + "kg (Peso)"

        if(currentPokemon!!.types.size == 1){
            binding.tvType3.text = currentPokemon!!.types[0].type.name.uppercase()
        }else{
            binding.tvType1.text = currentPokemon!!.types[0].type.name.uppercase()
            binding.tvType2.text = currentPokemon!!.types[1].type.name.uppercase()
        }

        binding.tvHP.text = currentPokemon!!.stats[0].base_stat.toString() + "%"
        binding.progressHP.progress = currentPokemon!!.stats[0].base_stat.toInt()

        binding.tvAttack.text = currentPokemon!!.stats[1].base_stat.toString() + "%"
        binding.progressAttack.progress = currentPokemon!!.stats[1].base_stat.toInt()

        binding.tvDefense.text = currentPokemon!!.stats[2].base_stat.toString() + "%"
        binding.progressDefense.progress = currentPokemon!!.stats[2].base_stat.toInt()

        binding.tvSpecialAttack.text = currentPokemon!!.stats[3].base_stat.toString() + "%"
        binding.progressSpecialAttack.progress = currentPokemon!!.stats[3].base_stat.toInt()

        binding.tvSpecialDefense.text = currentPokemon!!.stats[4].base_stat.toString() + "%"
        binding.progressSpecialDefense.progress = currentPokemon!!.stats[4].base_stat.toInt()

        binding.tvSpeed.text = currentPokemon!!.stats[5].base_stat.toString() + "%"
        binding.progressSpeed.progress = currentPokemon!!.stats[5].base_stat.toInt()

    }

}