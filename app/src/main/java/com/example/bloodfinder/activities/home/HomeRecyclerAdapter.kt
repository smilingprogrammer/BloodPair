package com.example.bloodfinder.activities.home

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodfinder.databinding.HomeItemListSectionBinding
import com.example.bloodfinder.network.getblood.BloodnCity

class HomeRecyclerAdapter(private var bloodnCity: List<BloodnCity>): RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {

    class ViewHolder(binding: HomeItemListSectionBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return bloodnCity.size
    }
}