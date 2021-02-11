package com.example.a7menuite_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_finish_activity.*
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.util.*

class Finish_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish_activity)

        setSupportActionBar(toolbar2)
        val toolbar = supportActionBar
        if (toolbar2 != null){

            toolbar!!.setDisplayHomeAsUpEnabled(true)
        }

        toolbar2.setNavigationOnClickListener {
            onBackPressed()
        }

        btn_finish.setOnClickListener {
           finish()

        }

        addcompletdate()
    }

    private fun addcompletdate (){
        val calender = Calendar.getInstance()
        val datetime = calender.time
        val sdf = SimpleDateFormat("dd MMM yyyy HH:mm:ss",Locale.getDefault())

        val date = sdf.format(datetime)


        val sqlitdatabase = Sqliteopenhelper(this)
        val mm =   sqlitdatabase.adddate(date)

        if (mm > -1){

            Toast.makeText(this,"sucsses",Toast.LENGTH_SHORT).show()
        }
    }

}