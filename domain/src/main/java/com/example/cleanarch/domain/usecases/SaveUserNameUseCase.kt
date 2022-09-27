package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.models.SaveUserNameParam
import com.example.cleanarch.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam):Boolean{

        val oldUserName = userRepository.getName()
        if(oldUserName.firsName == param.name){
            return true
        }


        val result:Boolean = userRepository.saveName(param)
        return result
    }
}