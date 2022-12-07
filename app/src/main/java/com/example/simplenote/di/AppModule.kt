package com.example.simplenote.di

import com.example.simplenote.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            getUserDataUseCase = get(),
            saveUserDataUseCase = get()
        )
    }
}