package com.example.swing_assignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.swing_assignment.R
import com.example.swing_assignment.data.model.ImageDataModel
import com.example.swing_assignment.databinding.FeedFragmentBinding

class FeedFragment : Fragment() {
    private var _binding: FeedFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        ImageListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FeedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() = with(binding) {
        val list : MutableList<ImageDataModel> = mutableListOf(
            ImageDataModel(R.drawable.bangsil, false),
            ImageDataModel(R.drawable.bangsil, false),
            ImageDataModel(R.drawable.bangsil, false),
            ImageDataModel(R.drawable.bangsil, false),
            ImageDataModel(R.drawable.bangsil, false),
            ImageDataModel(R.drawable.bangsil, false),
            ImageDataModel(R.drawable.bangsil, false)
        )

        listAdapter.submitList(list)
        val manager = GridLayoutManager(requireContext(), 2)

        rv.adapter = listAdapter
        rv.layoutManager = manager

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}