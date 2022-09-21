package com.example.clean.domain.usecases

import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName
import com.example.clean.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {
    fun execute():UserName{
        return userRepository.getName()
    }
}