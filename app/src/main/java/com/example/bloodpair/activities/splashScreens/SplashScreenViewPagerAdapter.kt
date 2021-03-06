package com.example.bloodpair.activities.splashScreens

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bloodpair.databinding.ActivitySplashItemBinding
import com.example.bloodpair.activities.auth.LoginActivity

class SplashScreenViewPagerAdapter(private var images: List<Int>): RecyclerView.Adapter<SplashScreenViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(private var binding: ActivitySplashItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setSlide(image: Int, position: Int){
            binding.IvImage.setImageResource(image)

            // If last slide show start button text and fade image
            if(position == 2){
                binding.btnStart.visibility = View.VISIBLE
                binding.txvAbout.visibility = View.VISIBLE
                binding.txvText.visibility = View.VISIBLE
                binding.IvImage.alpha = 0.3F
            }

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