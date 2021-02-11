package com.example.a7menuite_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        start_layoutb.setOnClickListener {
            val intent = Intent(this, exrcisActivity::class.java)
            startActivity(intent)

        }

        bmilayout.setOnClickListener {

            val intent = Intent(this, bmi::class.java)
            startActivity(intent)
        }

        history_layout.setOnClickListener {

            val intent = Intent(this, History::class.java)
            startActivity(intent)
        }
    }
}