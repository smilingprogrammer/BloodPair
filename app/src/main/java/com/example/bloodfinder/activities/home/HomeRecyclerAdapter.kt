package com.example.bloodfinder.activities.home

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bloodfinder.R
import com.example.bloodfinder.databinding.FragmentSearchListItemBinding
import com.example.bloodfinder.databinding.HomeItemListSectionBinding
import com.example.bloodfinder.network.getblood.BloodnCity
import com.example.bloodfinder.network.getblood.Bloods
import com.example.bloodfinder.network.getblood.Data

class HomeRecyclerAdapter(private var bloods: List<Data>,private var context: Context): RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder>() {

    class ViewHolder(private var binding: FragmentSearchListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(price: String, lab_name: String, blood_type: String, available_pints: String){
            var bloodTypeAbrv = ""
            if (blood_type == "o_positive") bloodTypeAbrv = "O+"
            if (blood_type == "o_nagative") bloodTypeAbrv = "O-"
            if (blood_type == "a_positive") bloodTypeAbrv = "A+"
            if (blood_type == "a_nagative") bloodTypeAbrv = "A-"
            if (blood_type == "b_positive") bloodTypeAbrv = "B+"
            if (blood_type == "b_negative") bloodTypeAbrv = "B-"
            if (blood_type == "ab_positive") bloodTypeAbrv = "AB+"
            if (blood_type == "ab_negative") bloodTypeAbrv = "AB-"

            binding.apply {
                searchFragmentItemPrice.text = "N $price"
                searchFragmentItemBloodType.text = "Blood Type: $bloodTypeAbrv"
                searchFragmentItemLab.text = lab_name
                searchFragmentItemPints.text = "$available_pints pints"
                searchFragmentItemImage.setImageResource(R.drawable.ic_blood_drop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            FragmentSearchListItemBinding.inflate(
                LayoutInflater.from(context),
                parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var blood = bloods[position]
        holder.setData(
            "350",
            "Timis Lab",
            "o_negative",
            "300"
        )
    }

    override fun getItemCount(): Int {
        return bloods.size
    }
}