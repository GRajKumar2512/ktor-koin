package com.example.vartalaap.feature_shows.domain.di

import com.example.vartalaap.feature_shows.data.repository.AppProductRepository
import com.example.vartalaap.feature_shows.domain.repository.ProductRepository
import com.example.vartalaap.feature_shows.presentation.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repoModule = module {
    singleOf(::AppProductRepository) { bind<ProductRepository>() }
    viewModel { ProductViewModel(get()) }
}

object ViewModelProvider : KoinComponent {
    fun getProductViewModel() = get<ProductViewModel>()
}