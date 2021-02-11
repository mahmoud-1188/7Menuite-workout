package com.example.a7menuite_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.iteam_history.*
import kotlin.math.log

class History : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        getalldata()

        setSupportActionBar(toolbar_history)

        val toolbar = supportActionBar
            toolbar?.title = "History"
        if (toolbar != null){

            toolbar.setDisplayHomeAsUpEnabled(true)
        }


        toolbar_history.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun getalldata (){

        val sqlitdatabase = Sqliteopenhelper(this)
       val data =  sqlitdatabase.getallcompletdatelist()

        if(data.size > 0){

            history_recycleview.visibility = View.VISIBLE

            no_data_avilabel.visibility =  View.GONE

            history_recycleview.layoutManager = LinearLayoutManager(this)
            val adapter = item_history_adapter(this,data)
            history_recycleview.adapter = adapter

        }else{

            history_recycleview.visibility = View.GONE


            no_data_avilabel.visibility =  View.VISIBLE
        }
    }
}