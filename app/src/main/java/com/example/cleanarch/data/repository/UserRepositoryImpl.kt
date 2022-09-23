package com.example.cleanarch.data.repository

import android.content.Context
import com.example.cleanarch.domain.models.SaveUserNameParam
import com.example.cleanarch.domain.models.UserName
import com.example.cleanarch.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"
private const val DEFAULT_LAST_NAME = "Default lastName"

class UserRepositoryImpl( context: Context):UserRepository {


    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

   override fun saveName(savepatam:SaveUserNameParam):Boolean{
       sharedPreferences.edit().putString(KEY_FIRST_NAME,savepatam.name).apply()
        return true
    }

   override fun getName():UserName{

       val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"")?:""
       val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME)?: DEFAULT_LAST_NAME




        return UserName(firsName = firstName,lastName=lastName)
    }
}