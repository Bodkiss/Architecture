package com.example.clean.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clean.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private  val vm: MainViewModel by viewModel<MainViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.e("AAA","Activity ceated")

        val textView: TextView = findViewById(R.id.textView)
        val editText: EditText = findViewById(R.id.editText)
        val btnGetUserData: Button = findViewById(R.id.btnGet)
        val btnSaveUserData: Button = findViewById(R.id.btnSave)

        vm.resultLive.observe(this,{
            textView.text = it
        })

        btnGetUserData.setOnClickListener {
            vm.load()
        }
        btnSaveUserData.setOnClickListener {
            val text = editText.text.toString()
          vm.save(text)
        }
    }
}