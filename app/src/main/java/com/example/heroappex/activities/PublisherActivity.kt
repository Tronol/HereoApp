package com.example.heroappex.activities


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
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
import com.example.heroappex.models.Publisher
import java.util.concurrent.Flow

class PublisherActivity : AppCompatActivity() {
    lateinit var logoutBtn : ImageView
    lateinit var dcBtn : ImageButton
    lateinit var marvelBtn : View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.publisher_activity)
        val sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE)
        logoutBtn = findViewById(R.id.logoutBtn)

        dcBtn = findViewById(R.id.dc)
        marvelBtn = findViewById(R.id.marvel)

        logoutBtn.setOnClickListener{
            Log.i("LOGOUT","CERRANDO SESION")
            val editor = sharedPreferences.edit()
            editor.remove("isLogged")
            editor.apply()
            val intent = Intent(this@PublisherActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        dcBtn.setOnClickListener {
            val dcCharacters = CharacterItem.characters.filter { it.id in 11..20 }
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            intent.putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(dcCharacters))
            intent.putExtra("COLOR", "#2c4461")
            startActivity(intent)
        }

        marvelBtn.setOnClickListener {
            val marvelCharacters = CharacterItem.characters.filter { it.id in 1..10 }
            val intent = Intent(this@PublisherActivity, HeroesActivity::class.java)
            intent.putParcelableArrayListExtra("CHARACTERS_LIST", ArrayList(marvelCharacters))
            intent.putExtra("COLOR", "#cc0000")
            startActivity(intent)
        }
    }
}