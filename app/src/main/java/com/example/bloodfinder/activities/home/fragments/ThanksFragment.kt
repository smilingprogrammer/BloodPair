package com.example.bloodfinder.activities.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bloodfinder.R
import com.example.bloodfinder.databinding.FragmentHelpBinding
import com.example.bloodfinder.databinding.FragmentThanksBinding

class ThanksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentThanksBinding.inflate(
            LayoutInflater.from(container?.context)
        )

        return binding.root
    }
}