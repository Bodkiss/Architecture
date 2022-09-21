package com.example.clean.data.storage

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName

interface UserStorage {
    fun save(user: User): Boolean

    fun getName(): User
}