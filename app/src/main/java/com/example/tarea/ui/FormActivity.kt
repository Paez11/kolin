package com.example.tarea.ui

import Data.DataDbHelper
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.tarea.R
import com.example.tarea.databinding.FormActivityBinding
import com.example.tarea.model.Contact

class FormActivity: AppCompatActivity() {
    private lateinit var editEmail: EditText
    private lateinit var editPhone: EditText
    private lateinit var editDate: EditText
    private lateinit var buttonDelete: Button
    private lateinit var buttonUpdate: Button
    private lateinit var textView: TextView
    private var db: DataDbHelper?=null
    private var idContact: Int = -1

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.form_activity)

        editEmail=findViewById(R.id.editName)
        editPhone=findViewById(R.id.editPhone)
        editDate=findViewById(R.id.editDate)
        editDate.setOnClickListener{ showDatePickerDialog() }
        buttonDelete=findViewById(R.id.buttonDelete)
        buttonUpdate=findViewById(R.id.buttonBack)
        textView=findViewById(R.id.textView)

        idContact = intent.getIntExtra("idContact",-1)
        if(idContact>-1){
            buttonDelete.visibility=View.VISIBLE
            buttonUpdate.setText("Update")
            textView.setText("Update/Remove Contact")
        }
        db= DataDbHelper(this)
        var contactToModify: Contact? = db!!.getContactById(idContact)
        if (contactToModify != null) {
            editEmail.setText(contactToModify.getEmail())
            editPhone.setText(contactToModify.getPhone())
            editDate.setText(contactToModify.getDate())
        }
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePick { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

    fun onDateSelected(day:Int, month:Int, year:Int){
        var monthFixed=month+1
        editDate.setText("$day/$monthFixed/$year")
    }

    fun addContact(view: View) {
        db= DataDbHelper(this)
        val contact = Contact(editEmail.text.toString(), editPhone.text.toString(),
            editDate.text.toString())
        var result: Long = -1
        val regex = Regex("(6|7)(\\d){8}")

        if(editEmail.text.isEmpty() || editPhone.text.isEmpty()) {
            Toast.makeText(this, "Please enter required fields.",Toast.LENGTH_SHORT).show()
        } else {
            if(editPhone.text.toString().matches(regex)) {
                if(idContact>-1) { //Update
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Attention, updating contact!!!")
                        .setMessage("Are you sure to update the contact?")
                        .setNegativeButton("Cancel") { view, _ ->
                            view.dismiss()
                        }
                        .setPositiveButton("Accept") { view, _ ->
                            view.dismiss()
                            contact.setId(idContact)
                            result = db!!.updateContact(contact).toLong()
                            if(result>-1){
                                Toast.makeText(applicationContext, "Contact saved successfully.",Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(applicationContext, "Contact not saved.",Toast.LENGTH_SHORT).show()
                            }
                            finish()
                        }
                        .setCancelable(false)
                        .create()
                    dialog.show()
                }
                else {
                    result = db!!.insertContact(contact)
                    if(result>-1){
                        Toast.makeText(applicationContext, "Contact saved successfully.",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Contact not saved.",Toast.LENGTH_SHORT).show()
                    }
                    finish()
                }
            }
            else {
                Toast.makeText(applicationContext, "Invalid phone number.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun removeContact(view: View) {
        db= DataDbHelper(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("Attention, eliminating contact!!!")
            .setMessage("Are you sure to delete the contact?")
            .setNegativeButton("Cancel") { view, _ ->
                view.dismiss()
            }
            .setPositiveButton("Accept") { view, _ ->
                view.dismiss()
                db!!.deleteContact(idContact)
                Toast.makeText(applicationContext, "Contact removed successfully.",Toast.LENGTH_SHORT).show()
                finish()
            }
            .setCancelable(false)
            .create()
        dialog.show()
    }
}