package com.olayg.taskapp.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.olayg.taskapp.R
import com.olayg.taskapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Toast.makeText(this, "Welcome", Toast.LENGTH_LONG).show()
    }

    private fun toggleMenuIcon(isList: Boolean) = with(binding.toolbar.menu[0]) {
        val icon = if (!isList) R.drawable.ic_grid_24 else R.drawable.ic_linear_24
        setIcon(icon)
        isChecked = !isList
    }

    fun setToolbarListener(listener: (Boolean) -> Unit) {
        binding.toolbar.setOnMenuItemClickListener {
            listener.invoke(it.isChecked)
            toggleMenuIcon(it.isChecked)

            true
        }
    }
}