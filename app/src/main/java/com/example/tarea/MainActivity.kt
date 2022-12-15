package com.example.tarea

import Data.DataDbHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var userName:EditText
    lateinit var cambiar:Button
    private var db: DataDbHelper? = null
    private var list:MutableList<Person> = ArrayList()
    private lateinit var date:String;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userName = findViewById(R.id.userName)
        cambiar = findViewById(R.id.cambiar)
        db = DataDbHelper(this)

        userName.addTextChangedListener {
            text ->  Log.d("Nombre de usuario",text.toString())
        }
        cambiar.setOnClickListener {
            //val intent =Intent(this,MainActivity2::class.java)
            //startActivity(intent)
            addDatos()
        }
    }
    private fun addDatos() {
        date = Calendar.getInstance().time.toString()
        list.add(Person(userName.text.toString(), date));
        Log.d("Nombre de usuario",userName.text.toString())
        Log.d("Fecha" , date)
        db!!.insert(list)
        userName.setText("")
    }
}