package com.example.tarea.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea.databinding.FormActivityBinding

class FormActivity: AppCompatActivity() {
    private lateinit var binding: FormActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FormActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        if (intent.hasExtra("contactId")) {
            val id: String? = intent.getStringExtra("contactId")
            binding.InsertBTN.visibility = View.GONE
            //TODO: Hacer una consulta a la base de datos con el id que paso como parametro y setear los campos nombres y telefono en los siguientes campos
            //binding.NamePT =
            //binding.PhonePT =

        }else{
            binding.InsertBTN.setOnClickListener{
                if (binding.NamePT.text.isNullOrBlank() && binding.PhonePT.text.isNullOrBlank()){
                    val Nombre = binding.NamePT.text
                    val date = binding.DatePT.text
                    val Phone = binding.PhonePT.text
                    //TODO: Insertar en la base de datos el contacto con el Nombre y Telefono de arriba (La id es autoincrementable)
                }
            }
        }
    }
}