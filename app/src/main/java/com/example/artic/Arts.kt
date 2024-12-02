package com.example.artic

import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate

class Arts(val id: Int, val name: String, val picture: String,
           val artdate: String, val country: String, val author: String, val description: String,
           val text: String, val isFavorite: Boolean) {}