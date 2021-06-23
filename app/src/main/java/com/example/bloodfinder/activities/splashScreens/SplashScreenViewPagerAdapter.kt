package com.example.bloodfinder.activities.splashScreens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodfinder.databinding.ActivitySplashItemBinding

class SplashScreenViewPagerAdapter(private var slideText: List<String>): RecyclerView.Adapter<SplashScreenViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: ActivitySplashItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setText(text: String){
            binding.txvText.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ActivitySplashItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val viewText = slideText[position]
        holder.setText(viewText)
    }

    override fun getItemCount(): Int {
        return slideText.size
    }

}