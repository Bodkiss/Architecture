package com.example.cleanarch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarch.R
import com.example.cleanarch.data.repository.UserRepositoryImpl
import com.example.cleanarch.data.storage.SharedPrefUserStorage
import com.example.cleanarch.domain.models.SaveUserNameParam
import com.example.cleanarch.domain.usecases.GetUserNameUseCase
import com.example.cleanarch.domain.usecases.SaveUserNameUseCase

class MainActivity : AppCompatActivity() {



    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA", "Activity created")

        viewModel = ViewModelProvider(this,MainViewModelFactory(this)).get(MainViewModel::class.java)


        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val btnGet = findViewById<Button>(R.id.btnGet)
        val btnSave = findViewById<Button>(R.id.btnSave)


        viewModel.resultLive.observe(this, Observer {
            textView.text = it
        })

        btnGet.setOnClickListener {
            viewModel.load()
        }


        btnSave.setOnClickListener {
            val text = editText.text.toString()
            viewModel.save(text)
        }


    }
}