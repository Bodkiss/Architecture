package com.example.cleanarch.domain.repository

import com.example.cleanarch.domain.models.SaveUserNameParam
import com.example.cleanarch.domain.models.UserName

interface UserRepository {
    fun saveName(saveparam: SaveUserNameParam):Boolean

    fun getName(): UserName
}