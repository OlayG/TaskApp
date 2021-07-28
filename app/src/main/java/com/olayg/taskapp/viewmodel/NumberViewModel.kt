package com.olayg.taskapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel() {

    private val numbers = MutableLiveData<List<Int>>()
    val numbersLD: LiveData<List<Int>>
        get() = numbers

    init {
        numbers.value = getMockData()
    }

    private fun getMockData() = mutableListOf<Int>().apply {
        for (i in 1..10) add(i)
    }

    fun updateList() {
        numbers.value = numbers.value?.let { numList ->
            numList + numList.last().plus(1)
        }
    }
}