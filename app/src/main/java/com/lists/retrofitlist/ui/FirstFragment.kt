package com.lists.retrofitlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.lists.retrofitlist.databinding.FragmentFirstBinding
import com.lists.retrofitlist.viewmodel.FirstViewModel
import com.lists.retrofitlist.viewmodel.NavigationDestination


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val viewModel by viewModels<FirstViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            viewModel.start()
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.destination.observe(viewLifecycleOwner) { status ->
            if (status != null) {
                val action = FirstFragmentDirections.actionFirstFragmentToDetailFragment()
                findNavController().navigate(action)
            }
        }


    }
}