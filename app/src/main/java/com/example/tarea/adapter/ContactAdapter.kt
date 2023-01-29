package com.example.tarea.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea.R
import com.example.tarea.model.Contact

class ContactAdapter(private val contactList: ArrayList<Contact>, private val onItemClicked: (Contact) -> Unit):  RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.contactNameTV)
        val date: DatePicker = view.findViewById(R.id.dateP)
        val phone: TextView = view.findViewById(R.id.contactPhoneNumberTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        runCatching {
            holder.name.text = contactList[position].getEmail()
            holder.date.maxDate = contactList[position].getdate()
            holder.phone.text = contactList[position].getPhone().toString()
            holder.itemView.setOnClickListener {
                onItemClicked.invoke(contactList[position])
            }

        }.onFailure {
            Log.e("ContactAdapter", it.message.toString())
        }
    }

    override fun getItemCount(): Int = contactList.size
}