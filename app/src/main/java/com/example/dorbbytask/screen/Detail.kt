package com.example.dorbbytask.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.dorbbytask.R
import com.example.dorbbytask.databinding.FragmentDetailBinding
import com.example.dorbbytask.models.AuthorResultItem
import com.example.dorbbytask.network.ApiUtils
import com.example.dorbbytask.utils.ImageLoad

class Detail : Fragment(R.layout.fragment_detail) {


    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)
        initSetView()
        initSetData()
    }

    private fun initSetData() {
        requireArguments().getSerializable(ApiUtils.DETAILS)?.let {
            it as AuthorResultItem
            setData(it)
        }
    }

    private fun setData(data: AuthorResultItem) {
        binding.apply {
            ImageLoad.loadImage(requireContext(), data.avatar, binding.imageView)
            descriptionTextView.text = data.descriptions
            titleTextView.text = data.name
        }
    }

    private fun initSetView() {
        val activity = requireActivity() as MainActivity
        activity.showBackBtn()
        activity.setTitleName(getString(R.string.detail))
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}