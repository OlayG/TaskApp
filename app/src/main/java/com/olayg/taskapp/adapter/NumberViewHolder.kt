package com.olayg.taskapp.adapter

import androidx.recyclerview.widget.RecyclerView
import com.olayg.taskapp.databinding.ItemNumberBinding

class NumberViewHolder(
    private val binding: ItemNumberBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(num: Int) = with(binding) {
        tvNum.text = num.toString()
    }
}