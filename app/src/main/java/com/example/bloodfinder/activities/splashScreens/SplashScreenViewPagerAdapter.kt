package com.example.bloodfinder.activities.splashScreens

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodfinder.activities.auth.LoginActivity
import com.example.bloodfinder.databinding.ActivitySplashItemBinding

class SplashScreenViewPagerAdapter(private var images: List<Int>): RecyclerView.Adapter<SplashScreenViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: ActivitySplashItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setSlide(image: Int, position: Int){
            binding.IvImage.setImageResource(image)

            // If last slide show start button
            if(position == 2) binding.btnStart.visibility = View.VISIBLE

            binding.btnStart.setOnClickListener{v ->
                val intent = Intent(v.context, LoginActivity::class.java)
                v.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ActivitySplashItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        holder.setSlide(image, position)
    }

    override fun getItemCount(): Int {
        return images.size
    }

}