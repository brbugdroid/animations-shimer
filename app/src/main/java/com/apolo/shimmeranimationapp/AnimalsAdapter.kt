package com.apolo.shimmeranimationapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalsAdapter(private val animals: List<AnimalModel>) : RecyclerView.Adapter<AnimalsAdapter.AnimalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        return AnimalViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.animal_view_holder, parent, false)
        )
    }

    override fun getItemCount() = animals.size

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bindAnimal(animals[position])
    }


    class AnimalViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
            fun bindAnimal(animal : AnimalModel) {
                view.apply {
                    findViewById<TextView>(R.id.name).text = view.context.getString(R.string.animal_name, animal.name)
                    findViewById<TextView>(R.id.age).text = view.context.getString(R.string.animal_age, animal.age.toString())
                    findViewById<TextView>(R.id.legs).text = view.context.getString(R.string.animal_legs, animal.legsNumber.toString())
                }


            }
    }

}