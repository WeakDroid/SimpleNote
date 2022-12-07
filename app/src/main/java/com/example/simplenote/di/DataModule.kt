package com.example.simplenote.di

import com.example.simplenote.data.repository.UserRepositoryImpl
import com.example.simplenote.data.storage.UserStorage
import com.example.simplenote.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.simplenote.domain.repository.UserRepository
import org.koin.dsl.module

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }
    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}