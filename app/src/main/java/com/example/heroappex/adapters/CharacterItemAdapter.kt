package com.example.heroappex.adapters


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.heroappex.R
import com.example.heroappex.models.CharacterItem
import com.squareup.picasso.Picasso
import java.util.Locale.Category

class CharacterItemAdapter(val itemList: List<CharacterItem>): RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //Aqui se contiene toda la logica
        val items = itemList[position]
        holder.itemImage
        Picasso.get().load(items.imagen).into(holder.itemImage)
        holder.itemView.setOnClickListener{
            Log.d("CharacterItemAdapter", "Item clicked: ${items.name}")
        }
    }

}

class ItemViewHolder(val view: View): ViewHolder(view){
    val itemImage : ImageView = view.findViewById(R.id.item_image)
}