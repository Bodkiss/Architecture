package com.example.clean.di

import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.SharedPrefUserStorage
import com.example.clean.data.storage.UserStorage
import com.example.clean.domain.repository.UserRepository
import org.koin.dsl.module
import org.koin.dsl.single




val dataModule = module {

    single<UserStorage>{
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository>{
        UserRepositoryImpl(userStorage = get())
    }
}