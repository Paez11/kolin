package Data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.tarea.model.Contact

class DataDbHelper (context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){
    private val db:SQLiteDatabase
    private val values:ContentValues
    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "_root_ide_package_.Data.Tables.Contacts"
    }
    init {
        db = this.writableDatabase
        values = ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE "+Tables.Contacts.TABLE_NAME+" (" +
            Tables.Contacts._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            Tables.Contacts.COLUMN_EMAIL + " TEXT NOT NULL," +
                Tables.Contacts.COLUMN_FECHA + " TEXT NOT NULL," +
        Tables.Contacts.COLUMN_PHONE + " TEXT NOT NULL");
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(contacts: List<Contact>) {
        values.put(Tables.Contacts.COLUMN_EMAIL,contacts[0].getEmail())
        values.put(Tables.Contacts.COLUMN_FECHA,contacts[0].getFecha())
        values.put(Tables.Contacts.COLUMN_PHONE,contacts[0].getPhone())
        db.insert(Tables.Contacts.TABLE_NAME,null,values)
    }

}