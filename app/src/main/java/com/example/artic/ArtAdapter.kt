package com.example.artic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArtAdapter(var workarts: List<Arts>, var context: Context) : RecyclerView.Adapter<ArtAdapter.MyViewHolder>()
{
    class MyViewHolder(view: View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.art_list_pic)
        val names: TextView = view.findViewById(R.id.art_list_name)
        val dates: TextView = view.findViewById(R.id.art_list_date)
        val country: TextView = view.findViewById(R.id.art_list_country)
        val author: TextView = view.findViewById(R.id.art_list_author)
        val desc: TextView = view.findViewById(R.id.art_list_description)
        val btn: Button = view.findViewById(R.id.art_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.art_in_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workarts.count()
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageId = context.resources.getIdentifier(
            workarts[position].picture,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)
        holder.names.text = workarts[position].name
        holder.dates.text = workarts[position].artdate
        holder.country.text = workarts[position].country
        holder.author.text = workarts[position].author
        holder.desc.text = workarts[position].description
        holder.btn.setOnClickListener {
            val intent = Intent(context, ArtActivity::class.java)


            intent.putExtra("desc", workarts[position].text)
            intent.putExtra("name", workarts[position].name)

            context.startActivity(intent)
        }
    }
}