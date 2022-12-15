package com.example.tarea

class Person {
    private var id: Int = 0
    private var name: String = ""
    private var fecha:String = ""

    constructor(name:String, fecha:String) {
        this.name = name
        this.fecha= fecha;
    }

    fun getId(): Int {
        return id;
    }
    fun getName():String {
        return name;
    }
    fun getFecha(): String {
        return fecha;
    }
}
