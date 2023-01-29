package Data

import com.example.tarea.model.Contact

class Tables {
    abstract class Contacts {
        companion object {
            val _ID = "_id"
            val TABLE_NAME = "contacts"
            val COLUMN_EMAIL = "email"
            val COLUMN_FECHA = "fecha"
            val COLUMN_PHONE = "telefono"
            var contacts: MutableList<Contact> = ArrayList()
        }
    }
}