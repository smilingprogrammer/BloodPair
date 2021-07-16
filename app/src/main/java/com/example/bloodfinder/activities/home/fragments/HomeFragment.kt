package com.example.bloodfinder.activities.home.fragments

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloodfinder.R
import com.example.bloodfinder.activities.home.HomeRecyclerAdapter
import com.example.bloodfinder.activities.home.HomeViewModel
import com.example.bloodfinder.databinding.FragmentHomeBinding
import com.example.bloodfinder.databinding.FragmentProfileBinding
import com.example.bloodfinder.network.getblood.Bloods
import com.example.bloodfinder.network.getblood.Data

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var binding: FragmentHomeBinding

    private lateinit var adapter: HomeRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(
            LayoutInflater.from(container?.context)
        )
        setHasOptionsMenu(true)

        viewModel.getAllAvailableBloods()

        viewModel.bloods.observe(viewLifecycleOwner, Observer { bloods ->
            populateAvailableBloods(bloods)
            Log.d("GET BLOODS EXCEPTION", ":::::::::: :::::: :::::: ::::::::::: :::::::::: ::::::::")

            adapter.notifyDataSetChanged()
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.top_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController()) || super.onOptionsItemSelected(item)
    }

    fun populateAvailableBloods(bloods: List<Data>){

        adapter = HomeRecyclerAdapter(bloods, requireContext())
        var recyclerView = binding.rcvBloods
        recyclerView.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayout.VERTICAL ))
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter
    }

}