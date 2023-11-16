package com.lists.retrofitlist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lists.retrofitlist.databinding.FragmentDetailBinding
import com.lists.retrofitlist.ui.recyclerview.CustomAdapter
import com.lists.retrofitlist.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    val detailViewModel: DetailViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclers.setHasFixedSize(true)
        binding.recyclers.layoutManager = LinearLayoutManager(requireContext())
        detailViewModel.projectsLiveData.observe(viewLifecycleOwner) { status ->
            binding.recyclers.adapter = CustomAdapter(requireContext(), status)
        }
    }
}