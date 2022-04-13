package com.example.bloodpair.activities.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bloodpair.databinding.FragmentThanksBinding

class ThanksFragment : Fragment() {

    private lateinit var binding: FragmentThanksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThanksBinding.inflate(
            LayoutInflater.from(container?.context)
        )

        return binding.root
    }
}