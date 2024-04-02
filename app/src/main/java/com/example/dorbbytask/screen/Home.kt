package com.example.dorbbytask.screen

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dorbbytask.R
import com.example.dorbbytask.adapter.MainAdapter
import com.example.dorbbytask.databinding.FragmentHomeBinding
import com.example.dorbbytask.network.ApiUtils
import com.example.dorbbytask.network.ResponseState
import com.example.dorbbytask.network.RetrofitClient
import com.example.dorbbytask.repository.MainRepository
import com.example.dorbbytask.utils.AlertErrorDialog
import com.example.dorbbytask.utils.ClickEventType
import com.example.dorbbytask.viewmodel.MainViewmodel
import com.example.dorbbytask.viewmodelfactory.MainViewmodelFactory


class Home : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!
    private val retrofit = RetrofitClient.apiInterface
    private val viewModel: MainViewmodel by viewModels {
        MainViewmodelFactory(MainRepository(retrofit))
    }

    private var mainAdapter = MainAdapter(ArrayList())


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        initSetView()
        initObserver()
        initListeners()

    }

    private fun initListeners() {
        mainAdapter.setOnItemClickListener { type, item ->
            when (type) {
                ClickEventType.ITEM_CLICK -> {
                    findNavController().navigate(
                        R.id.action_home2_to_detail,
                        bundleOf(ApiUtils.DETAILS to item)
                    )
                }

                ClickEventType.ANOTHER_CLICK_TYPE -> {}
            }

        }
    }

    private fun initSetView() {
        val activity = requireActivity() as MainActivity
        activity.hideBackBtn()
        activity.setTitleName(getString(R.string.home))
        viewModel.getPersonList()
    }

    private fun initObserver() {
        viewModel.authorList.observe(viewLifecycleOwner) { responseState ->
            when (responseState) {
                is ResponseState.Success -> {
                    binding.progressbar.visibility = View.GONE
                    mainAdapter.updateAdapter(responseState.data)
                    binding.rvList.apply {
                        layoutManager = LinearLayoutManager(
                            requireContext(),
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        adapter = mainAdapter
                    }
                }

                is ResponseState.Error -> {
                    binding.progressbar.visibility = View.GONE
                    AlertErrorDialog.showErrorDialog(requireContext(), responseState.message)
                }

                is ResponseState.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}