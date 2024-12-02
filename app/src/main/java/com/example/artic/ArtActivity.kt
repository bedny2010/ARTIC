package com.example.artic

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArtActivity : AppCompatActivity()
{
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ArtAdapter
    private lateinit var layoutManager: LinearLayoutManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_art)
        val name: TextView = findViewById(R.id.art_name)
        val desc: TextView = findViewById(R.id.art_descfull)
        val btn: Button = findViewById(R.id.art_favor_button)


        name.text = intent.getStringExtra("name")
        desc.text = intent.getStringExtra("desc")
        btn.setOnClickListener {  }
        }
    }
private fun addfavorite(){

}


