package com.example.cleanarch.data.storage

import com.example.cleanarch.data.storage.models.User

interface UserStorage {
    fun save(saveParam: User):Boolean

    fun get(): User
}