package com.olayg.taskapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.olayg.taskapp.adapter.NumberListAdapter
import com.olayg.taskapp.adapter.NumberRecyclerViewAdapter
import com.olayg.taskapp.databinding.FragmentNumberBinding
import com.olayg.taskapp.viewmodel.NumberViewModel

class NumberFragment : Fragment() {

    private var _binding: FragmentNumberBinding? = null
    private val binding: FragmentNumberBinding?
        get() = _binding

    private val viewModel by viewModels<NumberViewModel>()
    private val numbersRvAdapter by lazy { NumberRecyclerViewAdapter(mutableListOf()) }
    private val numbersListAdapter by lazy { NumberListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentNumberBinding.inflate(inflater, container, false).also {
        _binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            fabAdd.setOnClickListener {
                viewModel.updateList()
            }
            rvNumbers.adapter = numbersRvAdapter
        }

        viewModel.numbersLD.observe(viewLifecycleOwner) {
            //numbersListAdapter.submitList(it)

            numbersRvAdapter.updateList(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}