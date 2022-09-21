package com.example.clean.domain.usecases

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam):Boolean{
        val result :Boolean = userRepository.saveName(param)
        return result
    }
}