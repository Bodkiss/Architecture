package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.models.UserName
import com.example.cleanarch.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {



    fun execute(): UserName {


        return userRepository.getName()
    }
}