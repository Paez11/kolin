package com.example.tarea.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea.R
import com.example.tarea.databinding.InfoActivityBinding

class InfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.info_activity)
    }

    fun closeAbout(view: View){
        finish()
    }
}