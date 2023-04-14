package com.example.millenialfit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.millenialfit.R
import com.example.millenialfit.data.model.Training
import com.example.millenialfit.ui.FeaturedWorkoutScreenDirections

class VideoAdapter: RecyclerView.Adapter<VideoAdapter.ItemViewHolder>() {

    private var dataset = listOf<Training>()

    class ItemViewHolder(view: View): ViewHolder(view){
        val cardView: CardView = view.findViewById(R.id.sidescroller_cardview)
        val image: ImageView = view.findViewById(R.id.sidescroller_imageview)
        val title: TextView = view.findViewById(R.id.sidescroller_title)
    }

    fun submitList(list: List<Training>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sidescroller, parent, false)
        return ItemViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val trainingItem = dataset[position]

        holder.cardView.setOnClickListener {
            Navigation.findNavController(holder.itemView).navigate(FeaturedWorkoutScreenDirections.actionFeaturedWorkoutScreenToExerciseDetailFragment(trainingItem.id))
        }
        holder.image.load(trainingItem.image)
        holder.title.text = trainingItem.title
    }
}