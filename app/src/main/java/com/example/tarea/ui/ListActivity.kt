package com.example.tarea.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea.R
import com.example.tarea.adapter.ContactAdapter
import com.example.tarea.databinding.ListActivityBinding
import com.example.tarea.model.Contact

class ListActivity: AppCompatActivity() {
    private lateinit var binding: ListActivityBinding

    private var contactList: ArrayList<Contact> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        //TODO: Añadir a la lista contactList los contactos de la base de datos

        binding.contactRV.layoutManager = LinearLayoutManager(this)
        binding.contactRV.adapter = ContactAdapter(contactList, onItemClicked = { contact ->
            val i = Intent(this, FormActivity::class.java)
            i.putExtra("contactId", contact.getId())
            startActivity(i)
        })

        binding.btnNew.setOnClickListener {
            val i = Intent(this, FormActivity::class.java)
            startActivity(i)
        }

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
        val menu = menu.findItem(R.id.menu_item)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val i = Intent(this, InfoActivity::class.java)
        startActivity(i)
        return when (item.itemId) {
            R.id.menu_item -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}