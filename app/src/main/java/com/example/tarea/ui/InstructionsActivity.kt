package com.example.tarea.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea.R
import com.example.tarea.databinding.InstructionsActivityBinding

class InstructionsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.instructions_activity)
    }

    fun closeInstructions(view: View){
        finish()
    }
}