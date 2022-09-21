package com.example.clean.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.clean.data.repository.UserRepositoryImpl
import com.example.clean.data.storage.SharedPrefUserStorage
import com.example.clean.domain.models.SaveUserNameParam
import com.example.clean.domain.models.UserName
import com.example.clean.domain.usecases.GetUserNameUseCase
import com.example.clean.domain.usecases.SaveUserNameUseCase

class MainViewModel(private val getUserNameUseCase:GetUserNameUseCase,
                    private val saveUserNameUseCase: SaveUserNameUseCase
                    ):ViewModel() {
    private val resultLiveMutable = MutableLiveData<String>()
    val resultLive:LiveData<String> = resultLiveMutable


    init {
        Log.e("AAA","VM ceated")
    }

    override fun onCleared() {
        Log.e("AAA","VM cleard")
        super.onCleared()
    }

    fun save(text:String){
        val params = SaveUserNameParam(text)
        val resultData: Boolean = saveUserNameUseCase.execute(params)
        resultLiveMutable.value = "Save result $resultData"
    }
    fun load(){
        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName}  ${userName.lastName}"

    }


}