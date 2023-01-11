package com.example.daggermvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggermvvm.models.Product
import com.example.daggermvvm.repository.ProductRepository
import com.example.daggermvvm.utils.NetworkResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository): ViewModel() {

    val products: LiveData<NetworkResponse<List<Product>>>
    get() {
        return repository.products
    }

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }

}