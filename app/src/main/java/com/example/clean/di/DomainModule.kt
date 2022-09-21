package com.example.clean.di

import com.example.clean.domain.usecases.GetUserNameUseCase
import com.example.clean.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module{

    factory<GetUserNameUseCase> {
        GetUserNameUseCase(userRepository = get())
    }

    factory<SaveUserNameUseCase> {
        SaveUserNameUseCase(userRepository = get())
    }

}