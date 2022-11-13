package com.example.nasaapp.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.data.NearEarth
import com.example.nasaapp.databinding.AsteroidItemBinding


class HomeAsteroidsAdapter(private val onAsteroidsItemClicked: OnAsteroidsItemClicked):
    ListAdapter<NearEarth, HomeAsteroidsViewHolder>(
    DIFF_UTIL
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAsteroidsViewHolder {
        return HomeAsteroidsViewHolder.from(parent, onAsteroidsItemClicked)
    }

    override fun onBindViewHolder(holder: HomeAsteroidsViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object{

        private val DIFF_UTIL = object : DiffUtil.ItemCallback<NearEarth>(){
            override fun areItemsTheSame(oldItem: NearEarth, newItem: NearEarth): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: NearEarth, newItem: NearEarth): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

}

class HomeAsteroidsViewHolder(private val binding: AsteroidItemBinding,private val onAsteroidsItemClicked: OnAsteroidsItemClicked): RecyclerView.ViewHolder(binding.root){

    fun onBind(nearEarth: NearEarth){
        binding.nearEarth = nearEarth

        binding.root.setOnClickListener {
            onAsteroidsItemClicked.onAsteroidClicked(nearEarth)
        }
    }

    companion object{

        fun from(viewGroup: ViewGroup, onAsteroidsItemClicked: OnAsteroidsItemClicked): HomeAsteroidsViewHolder {
            val binding = AsteroidItemBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)

            return HomeAsteroidsViewHolder(binding,onAsteroidsItemClicked)
        }
    }
}

interface OnAsteroidsItemClicked{
    fun onAsteroidClicked(nearEarth: NearEarth)
}