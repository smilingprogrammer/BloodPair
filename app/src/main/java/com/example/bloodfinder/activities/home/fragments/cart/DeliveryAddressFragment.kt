package com.example.bloodfinder.activities.home.fragments.cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bloodfinder.R
import com.example.bloodfinder.databinding.FragmentDeliveryAddressBinding
import com.example.bloodfinder.databinding.FragmentProfileBinding

class DeliveryAddressFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDeliveryAddressBinding.inflate(
            LayoutInflater.from(container?.context)
        )

        return binding.root
    }
}