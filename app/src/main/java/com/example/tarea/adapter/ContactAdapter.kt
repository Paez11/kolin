package com.example.tarea.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea.R
import com.example.tarea.model.Contact
import com.example.tarea.ui.ClickListener

class ContactAdapter(private val onContactClickListener: ClickListener) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    var contacts: ArrayList<Contact> = ArrayList()
    lateinit var context: Context

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName = view.findViewById(R.id.emailTextView) as TextView
        val contactDate = view.findViewById(R.id.emailTextView) as TextView
        val contactPhone = view.findViewById(R.id.phoneTextView) as TextView

        fun bind(contact: Contact, context: Context){
            contactName.text = contact.getEmail()
            contactDate.text = contact.getDate()
            contactPhone.text = contact.getPhone()
        }
    }

    fun ContactAdapter(contacts : ArrayList<Contact>, context: Context){
        this.contacts = contacts
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(layoutInflater.inflate(R.layout.contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item, context)

        holder.itemView.setOnClickListener{
            onContactClickListener.onContactItemClicked(position)
        }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}