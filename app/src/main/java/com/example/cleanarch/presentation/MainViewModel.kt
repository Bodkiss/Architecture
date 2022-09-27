package com.example.cleanarch.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarch.data.repository.UserRepositoryImpl
import com.example.cleanarch.data.storage.SharedPrefUserStorage
import com.example.cleanarch.domain.models.SaveUserNameParam
import com.example.cleanarch.domain.usecases.GetUserNameUseCase
import com.example.cleanarch.domain.usecases.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private var resultLiveMutable = MutableLiveData<String>()
    val resultLive:LiveData<String> = resultLiveMutable

    init {
        Log.e("AAA", "ViewModel created")
    }

    override fun onCleared() {
        Log.e("AAA", "ViewModel cleared")
        super.onCleared()
    }



    fun save(text: String) {
        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
         resultLiveMutable.value = "Save result = $resultData"
    }

    fun load() {
        val userName = getUserNameUseCase.execute()
       resultLiveMutable.value =  "${userName.firsName} ${userName.lastName}"
    }

}