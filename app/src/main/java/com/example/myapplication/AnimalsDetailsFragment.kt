package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.myapplication.models.Animal
import com.squareup.picasso.Picasso

class AnimalsDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val animal = arguments?.getParcelable("animal", Animal::class.java)
        val name = view.findViewById<TextView>(R.id.name)
        val gender = view.findViewById<TextView>(R.id.gender)
        val size = view.findViewById<TextView>(R.id.size)
        val breed = view.findViewById<TextView>(R.id.breed)
        val photo = view.findViewById<ImageView>(R.id.banner)
        name.text = "Name: ${animal?.name}"
        gender.text = "Gender: ${animal?.gender}"
        size.text = "Size: ${animal?.size}"
        breed.text = "Breed: ${animal?.breeds?.primary}"
        val photoUrl = animal?.photos?.firstOrNull {
            it.large != null
        }
        if (photoUrl?.large != null) {
            Picasso.get().load(photoUrl.large).into(photo)
        } else {
            Picasso.get().load(R.drawable.ic_placeholder).into(photo)
        }
    }
}