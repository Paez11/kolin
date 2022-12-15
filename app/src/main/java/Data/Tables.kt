package Data

import com.example.tarea.Person

class Tables {
    abstract class Persons {
        companion object {
            val _ID = "_id"
            val TABLE_NAME = "persons"
            val COLUMN_NAME = "name"
            val COLUMN_FECHA = "fecha"
            var persons: MutableList<Person> = ArrayList()
        }
    }
}