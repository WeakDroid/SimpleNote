package com.example.simplenote.di

import com.example.simplenote.domain.usecase.GetUserDataUseCase
import com.example.simplenote.domain.usecase.SaveUserDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetUserDataUseCase> {
        GetUserDataUseCase(userRepository = get())
    }

    factory<SaveUserDataUseCase> {
        SaveUserDataUseCase(userRepository = get())
    }
}