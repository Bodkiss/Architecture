package com.example.cleanarch.domain.usecases

import com.example.cleanarch.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firsName = "Bodkiss", "Me")
    }
}