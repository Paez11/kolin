package com.example.tarea.model

import java.util.Date

class Contact {
    private var id: Int = 0
    private var email: String = ""
    private var date: Long = 0
    private var phone:Long = 0

    constructor(id: Int, email: String, date: Long, phone: Long) {
        this.id = id
        this.email = email
        this.date = date
        this.phone = phone
    }

    constructor(){}


    fun getId(): Int {
        return id;
    }
    fun getEmail():String {
        return email;
    }
    fun getdate(): Long {
        return date;
    }

    fun getPhone(): Long{
        return phone;
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
        if (date != other.date) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + email.hashCode()
        result = 31 * result + date.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }


}
