package com.example.heroappex.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heroappex.MainActivity
import com.example.heroappex.R
import com.example.heroappex.adapters.CharacterItemAdapter
import com.example.heroappex.models.CharacterItem


class HeroesActivity : AppCompatActivity() {

    lateinit var backHeroes: ImageView
    lateinit var itemRecyclerView: RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_heroes)

        //Colores
        val colorHex = intent.getStringExtra("COLOR")
        colorHex?.let {
            val color = Color.parseColor(it)
            window.decorView.setBackgroundColor(color) // Aplica el color de fondo
        }

        //Filtro listas
        val charactersList = intent.getParcelableArrayListExtra<CharacterItem>("CHARACTERS_LIST")

        backHeroes = findViewById(R.id.back_heroes)
        backHeroes.setOnClickListener {
            val intent = Intent(this@HeroesActivity, PublisherActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Filtro recicle
        itemRecyclerView = findViewById(R.id.heroes_list)
        itemRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        charactersList?.let {
            itemRecyclerView.adapter = CharacterItemAdapter(it)
        }
    }
}