package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam):Boolean{
        return !param.name.isEmpty()
    }
}