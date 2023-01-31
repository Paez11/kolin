package com.example.tarea.ui

import Data.DataDbHelper
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea.R
import com.example.tarea.adapter.ContactAdapter
import com.example.tarea.model.Contact

class MainActivity: AppCompatActivity(), ClickListener {

    private lateinit var recyclerViewContacts : RecyclerView
    private var contactAdapter : ContactAdapter = ContactAdapter(this)
    private var db: DataDbHelper?=null
    private lateinit var contacts:ArrayList<Contact>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        //loadData()
    }

    override fun onResume() {
        super.onResume()
        //loadData()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_instructions -> startActivity(Intent(this, AboutActivity::class.java))
            R.id.action_about -> startActivity(Intent(this, AboutActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onContactItemClicked(position: Int) {
        val intent = Intent(this, FormActivity::class.java)
        intent.putExtra("idContact", contacts[position].getId())
        startActivity(intent)
    }

    private fun loadData() {
        contacts=getContacts()
        contactAdapter.ContactAdapter(contacts, this)

        recyclerViewContacts = findViewById<RecyclerView>(R.id.recyclerViewContacts)
        recyclerViewContacts.setHasFixedSize(true)
        recyclerViewContacts.layoutManager = LinearLayoutManager(this)
        recyclerViewContacts.adapter = contactAdapter
    }

    fun nextView(view: View) {
        val next = Intent(this,FormActivity::class.java)
        startActivity(next)
    }

    fun getContacts(): ArrayList<Contact> {
        db = DataDbHelper(this)
        return db!!.getAllContacts()
    }
}