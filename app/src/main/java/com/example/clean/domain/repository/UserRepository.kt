package com.example.clean.domain.repository

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName
import com.example.clean.domain.usecases.SaveUserNameUseCase

interface UserRepository {
    fun saveName(saveParam: SaveUserNameParam):Boolean
    fun getName(): UserName
}