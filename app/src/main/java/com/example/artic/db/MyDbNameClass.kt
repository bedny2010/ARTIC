package com.example.artic.db

import android.provider.BaseColumns

object MyDbNameClass : BaseColumns {
    const val TABLE_NAME = "user"
    const val  COLUM_NAME_NICKNAME = "nik"
    const val  COLUM_NAME_EMAIL = "email"
    const val  COLUM_NAME_PASSWORD = "password"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "articdb.db"
    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME ("+
            "${BaseColumns._ID} INTEGER PRIMARY KEY, "+
            "$COLUM_NAME_NICKNAME TEXT, "+
            "$COLUM_NAME_EMAIL TEXT, "+
            "$COLUM_NAME_PASSWORD TEXT)"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"

    const val TABLE_NAME1 = "artwork"
    const val  COLUM_NAME_ARTWORK_NAME = "artwork_name"
    const val COLUM_NAME_ARTWORK = "artwork_picture"
    const val COLUM_NAME_ARTWORK_DATE = "artwork_date"
    const val COLUM_NAME_ARTWORK_COUNTRY = "country"
    const val COLUM_NAME_ARTWORK_AUTHOR = "author"
    const val COLUM_NAME_ARTWORK_DESCRIPTION = "description"
    const val CREATE_TABLE_ARTWORK = "CREATE TABLE IF NOT EXISTS $TABLE_NAME1 ("+
            "${BaseColumns._ID} INTEGER PRIMARY KEY, "+
            "$COLUM_NAME_ARTWORK_NAME TEXT, "+
            "$COLUM_NAME_ARTWORK TEXT, "+
            "$COLUM_NAME_ARTWORK_DATE TEXT, "+
            "$COLUM_NAME_ARTWORK_COUNTRY TEXT, "+
            "$COLUM_NAME_ARTWORK_AUTHOR TEXT, "+
            "$COLUM_NAME_ARTWORK_DESCRIPTION TEXT)"
    const val SQL_DELETE_TABLE1 = "DROP TABLE IF EXISTS $TABLE_NAME1"
}