package com.example.millenialfit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.millenialfit.R
import com.example.millenialfit.data.model.Training
import com.example.millenialfit.ui.HomeFragmentDirections
import com.example.millenialfit.ui.HomescreenDirections

class home_adapter() : RecyclerView.Adapter<home_adapter.itemViewHolder>() {

    private var dataset = listOf<Training>()

    //Implement the elements from the layout
    class itemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val cardView = view.findViewById<CardView>(R.id.home_cardview)
        val imageView = view.findViewById<ImageView>(R.id.workout_image_imageview)
        val title = view.findViewById<TextView>(R.id.planl_exercise_textview)
    }

    fun submitList(list: List<Training>) {
        dataset = list
        notifyDataSetChanged()
    }

    //Layout inflation
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home_recyclerview, parent, false)

        return itemViewHolder(adapterLayout)
    }

    //To set/distribute the resources to each element in the layout
    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val training = dataset[position]

        holder.cardView.setOnClickListener {
            Navigation.findNavController(holder.itemView).navigate(HomescreenDirections.actionHomescreenToExerciseDetailFragment(training.id))
        }
        holder.imageView.load(training.image)
        holder.title.text = training.title

    }

    //To inform the viewHolder how many views there is
    override fun getItemCount(): Int {
        return dataset.size
    }
}