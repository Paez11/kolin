package com.example.tarea.model

import java.util.Date

class Contact {
    private var id: Int = 0
    private var email: String = ""
    private var phone: String = ""
    private var date: String = ""

    constructor(id: Int,email: String, phone: String, date: String){
        this.id=id
        this.email=email
        this.phone=phone
        this.date=date
    }

    constructor(id: Int,email: String, phone: String){
        this.id=id
        this.email=email
        this.phone=phone
    }

    constructor(email: String, phone: String, date: String){
        this.email=email
        this.phone=phone
        this.date=date
    }

    constructor(){}

    fun setId(id: Int) {
        this.id = id
    }

    fun getId(): Int {
        return id;
    }
    fun getEmail(): String {
        return email;
    }

    fun setEmail(email: String){
        this.email=email;
    }
    fun getDate(): String {
        return date;
    }

    fun setDate(date: String){
        this.date = date;
    }

    fun getPhone(): String{
        return phone;
    }

    fun setPhone(phone: String){
        this.phone = phone
    }



    override fun toString(): String {
        return "Person(id=$id, email='$email', date='$date', phone=$phone)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Contact

        if (id != other.id) return false
        if (email != other.email) return false
        if (phone != other.phone) return false
        if (date != other.date) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + email.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + date.hashCode()
        return result
    }


}
