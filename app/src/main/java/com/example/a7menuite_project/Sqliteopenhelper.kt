package com.example.a7menuite_project

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sqliteopenhelper (context:Context):
    SQLiteOpenHelper (context,DATABASE_NAME,null, DATABASE_VERSION){


    companion object{

        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Minutesworkout"
        private const val TABLE_HISTORY = "history"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_COMPLET_DATE = "complete_date"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_DATE_TABLE = ("CREATE TABLE "+ TABLE_HISTORY + "("
                                     + COLUMN_ID + " INTEGER PRIMARY KEY," +
                                      COLUMN_COMPLET_DATE + " TEXT" + ")")

        db?.execSQL(CREATE_DATE_TABLE)
    }

    override fun onUpgrade(dp: SQLiteDatabase?, p1: Int, p2: Int){
        dp!!.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY)

        onCreate(dp)
    }

    fun adddate (date:String):Long {
        val dp = this.writableDatabase

        val valuse = ContentValues()

        valuse.put(COLUMN_COMPLET_DATE,date)



       val sucsses= dp.insert(TABLE_HISTORY,null,valuse)

        dp.close()
        return sucsses
    }

    fun getallcompletdatelist():ArrayList<String>{
        val list = ArrayList<String>()
        val dp = readableDatabase
        val cursor = dp.rawQuery("SELECT * FROM  $TABLE_HISTORY",null )

        while (cursor.moveToNext()){

            val datevalue = cursor.getString(cursor.getColumnIndex(COLUMN_COMPLET_DATE))
            list.add(datevalue)

            }
          cursor.close()

        return list

        }

}