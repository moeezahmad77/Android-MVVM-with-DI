package com.example.daggermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.daggermvvm.databinding.ActivityMainBinding
import com.example.daggermvvm.repository.ProductRepository
import com.example.daggermvvm.utils.NetworkResponse
import com.example.daggermvvm.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        subscriber()
    }

    private fun subscriber() {
        mainViewModel.products.observe(this) {
            when(it) {
                is NetworkResponse.Failure -> {
                    Toast.makeText(this, "FAIL ${it.error.toString()}", Toast.LENGTH_LONG).show()
                }
                is NetworkResponse.Loading -> {
                    Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show()
                }
                is NetworkResponse.Success -> {
                    Toast.makeText(this, "Success", Toast.LENGTH_LONG).show()
                    binding.txt.text = it.data!!.joinToString { x -> x.title + "\n\n" }
                }
            }
        }
    }
}