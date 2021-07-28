package com.olayg.taskapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.olayg.taskapp.databinding.ItemNumberBinding

private val DIFF_CALLBACK : DiffUtil.ItemCallback<Int> = object : DiffUtil.ItemCallback<Int>() {
    override fun areItemsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Int, newItem: Int) = oldItem == newItem
}

class NumberListAdapter : ListAdapter<Int, NumberViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val binding = ItemNumberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) = with(holder) {
        bind(getItem(position))
    }

}