package com.olayg.taskapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olayg.taskapp.databinding.ItemNumberBinding

class NumberRecyclerViewAdapter(
    private val numList: MutableList<Int>,
    private val listener: NumberRecyclerViewListener
) : RecyclerView.Adapter<NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(binding).apply {
            itemView.setOnClickListener {
                listener.numberClicked(numList[adapterPosition])
            }
        }
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) = with(holder) {
        bind(numList[position])
    }

    override fun getItemCount() = numList.size

    fun updateList(num: Int) = with(numList) {
        add(num)
        notifyItemInserted(numList.size - 1)
    }

    fun updateList(nums: List<Int>) = with(numList) {
        clear()
        addAll(nums)
        notifyItemRangeChanged(0, nums.size)
    }

    interface NumberRecyclerViewListener {
        fun numberClicked(num: Int)
    }

}