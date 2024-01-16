package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.models.Animal
import com.squareup.picasso.Picasso

class MainScreenRecyclerViewAdapter(
     var animalsList: List<Animal>,
    var onItemViewClicked: ((Animal) -> Unit)? = null
) : RecyclerView.Adapter<MainScreenRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_recyclerview, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = animalsList[position]
        holder.name.text = listItem.name
        holder.breed.text = listItem.breeds?.primary
        val photo = listItem.photos?.firstOrNull {
            it.medium != null
        }
        if (photo?.medium != null) {
            Picasso.get().load(photo.medium).into(holder.image)
        } else {
            Picasso.get().load(R.drawable.ic_placeholder).into(holder.image)
        }
        holder.itemView.setOnClickListener {
            onItemViewClicked?.invoke(listItem)
        }
    }

    override fun getItemCount() = animalsList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.animalPhoto)
        var name: TextView = itemView.findViewById(R.id.animalName)
        var breed: TextView = itemView.findViewById(R.id.animalBreed)
    }

}