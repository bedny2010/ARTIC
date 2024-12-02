package com.example.artic.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.artic.model.UserClass

class MyDbManager(val context: Context)
{
    val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDbHelper.writableDatabase
    }
    fun insertToDb(nik: String, email: String, password: String){
        val values = ContentValues().apply {
            put(MyDbNameClass.COLUM_NAME_NICKNAME, nik)
            put(MyDbNameClass.COLUM_NAME_EMAIL, email)
            put(MyDbNameClass.COLUM_NAME_PASSWORD, password)
        }
        db?.insert(MyDbNameClass.TABLE_NAME, null, values)
    }

    fun readDbData(): ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            MyDbNameClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        with(cursor) {
            while (this?.moveToNext() == true) {

                val columnIndex = this.getColumnIndex(MyDbNameClass.COLUM_NAME_NICKNAME)
                if (columnIndex != -1) {
                    val dataText = this.getString(columnIndex)
                    dataList.add(dataText)
                }
            }
            cursor?.close()
            return dataList
        }
    }
    fun getUser(nik: String, password: String): UserClass? {
        var user: UserClass? = null

        // Открываем базу данных
        openDb()

        // Формируем запрос
        val selection = "${MyDbNameClass.COLUM_NAME_NICKNAME} = ? AND ${MyDbNameClass.COLUM_NAME_PASSWORD} = ?"
        val selectionArgs = arrayOf(nik, password)

        // Выполняем запрос
        val cursor = db?.query(
            MyDbNameClass.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )


        if (cursor != null && cursor.moveToFirst()) {

            user = UserClass(
                nickname = cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUM_NAME_NICKNAME)),
                email = cursor.getString(cursor.getColumnIndexOrThrow(MyDbNameClass.COLUM_NAME_EMAIL))
            )
        }


        cursor?.close()
        closeDb()

        return user
    }

    fun closeDb(){
        myDbHelper.close()
    }
}