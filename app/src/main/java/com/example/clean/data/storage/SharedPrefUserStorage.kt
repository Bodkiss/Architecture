package com.example.clean.data.storage

import android.content.Context

import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "firstName"
private const val KEY_LAST_NAME = "lastName"


class SharedPrefUserStorage(context: Context):UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)


    override fun save(user:User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun getName(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME,"")?:""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME,"Default Name")?:"Default Name"
        return User(firstName,lastName)
    }
}