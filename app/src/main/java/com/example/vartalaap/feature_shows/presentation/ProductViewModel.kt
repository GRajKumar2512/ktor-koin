package com.example.vartalaap.feature_shows.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vartalaap.feature_shows.domain.repository.ProductRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {
    private val _state = MutableStateFlow(ProductState())
    val state = _state.asStateFlow()

    init {
        getSingleProduct(75)
    }

    private fun getSingleProduct(id: Int) {
        viewModelScope.launch {
            productRepository.getSingleProduct(id).collect { value ->
                Log.d("getSingleProduct", value.loading.toString())
                _state.update {
                    it.copy(singleProduct = value)
                }
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }
}