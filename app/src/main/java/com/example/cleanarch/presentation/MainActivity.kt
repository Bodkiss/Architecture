package com.example.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cleanarch.R
import com.example.cleanarch.data.repository.UserRepositoryImpl
import com.example.cleanarch.data.storage.SharedPrefUserStorage
import com.example.cleanarch.domain.models.SaveUserNameParam
import com.example.cleanarch.domain.usecases.GetUserNameUseCase
import com.example.cleanarch.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {

    private val userRepository by lazy(LazyThreadSafetyMode.NONE)
    { UserRepositoryImpl(userStorage = SharedPrefUserStorage(context = applicationContext)) }


    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE)
    { GetUserNameUseCase(userRepository) }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE)
    { SaveUserNameUseCase(userRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val btnGet = findViewById<Button>(R.id.btnGet)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnGet.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            textView.text = "First name - ${userName.firsName}"
        }


        btnSave.setOnClickListener {
            val text = editText.text.toString()
            val params = SaveUserNameParam(name = text)
            val result: Boolean = saveUserNameUseCase.execute(param = params)
            textView.text = "Save result =  $result"
        }


    }
}