package com.example.a7menuite_project

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.MediaStore
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.back_dialog.*
import kotlinx.android.synthetic.main.back_dialog.view.*
import java.util.*
import kotlin.collections.ArrayList

class exrcisActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var resttime :CountDownTimer? = null
    private var restprogress = 0
    private var resttime2 :CountDownTimer? = null
    private var restprogress2 = 0
    private var exerciselist : ArrayList<exercisemodel>? = null
    private var currentposition = -1
    private  var upcomingexercise = 0
    private var tts :TextToSpeech? = null
    private var player : MediaPlayer? = null
    private var exerciseadapter :exercise_statuse_adapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)




        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
            actionbar?.title = "Exercises"
        if (actionbar != null){

            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        toolbar.setNavigationOnClickListener {

            backdialog()
        }

        tts = TextToSpeech(this,this)
        exerciselist = Constant.defaultExerciselist()

        setrestview()

        setexerciserecycleview()
    }

    private fun backdialog (){

        val alertbudler = AlertDialog.Builder(this)
        val view = LayoutInflater.from(this).inflate(R.layout.back_dialog,null)
        val alertdialog = alertbudler.create()
        alertdialog.setView(view)
        alertdialog.show()

        view.button.setOnClickListener {
            finish()
        }

        view.button2.setOnClickListener {

        alertdialog.dismiss()
        }


    }
    override fun onDestroy() {
        if (resttime != null){

            resttime!!.cancel()
        }

        if (resttime2 != null) {

            resttime2!!.cancel()
        }

        if (tts != null){

            tts!!.stop()
            tts!!.shutdown()
        }
        if (player != null){

           player!!.stop()

        }
        super.onDestroy()
    }

    private fun setrestprogressbar (){

       upcoming.text = exerciselist!![upcomingexercise].name
          upcomingexercise++

        resttime = object :CountDownTimer(10000,1000){
            override fun onTick(p0: Long) {
                restprogress++

                progress.progress = 10-restprogress
                txt.text = (10-restprogress).toString()

            }

            override fun onFinish() {

                setexercisview()
                setrestprogress2()
            }

        }.start()

    }

    private fun setrestprogress2 (){

        resttime2 = object :CountDownTimer(30000,1000){
            override fun onTick(p0: Long) {

                restprogress2++

                progress2.progress = 30-restprogress2
                txt2.text = (30-restprogress2).toString()
            }

            override fun onFinish() {
                if (currentposition < exerciselist!!.size -1){

                    exerciselist!![currentposition].set_isselected(false)
                    exerciselist!![currentposition].set_iscomplet(true)
                    exerciseadapter!!.notifyDataSetChanged()

                    layout1.visibility = View.VISIBLE
                    layout2.visibility = View.GONE
                    setrestview()
                }else{
                      finish()
                    val intent = Intent("finish")
                    startActivity(intent)
                }
            }
        }.start()

    }

    private fun setexercisview (){

        if ( resttime2 != null){
            resttime2!!.cancel()
            resttime2 = null
            restprogress2 = 0
        }

        currentposition++

        exerciselist!![currentposition].set_isselected(true)
        exerciseadapter!!.notifyDataSetChanged()

        layout1.visibility = View.GONE
        layout2.visibility = View.VISIBLE

        speakOut(exerciselist!![currentposition].name)

        imagexercis.setImageResource(exerciselist!![currentposition].image)
        txtex.text = exerciselist!![currentposition].name
    }

    private fun setrestview (){

        if (resttime != null){
            resttime!!.cancel()
            resttime = null
            restprogress = 0
        }

        player = MediaPlayer.create(applicationContext,R.raw.press_start)
        player!!.isLooping = false
        player!!.start()

        setrestprogressbar()
    }

    override fun onInit(p0: Int) {
      if (p0 == TextToSpeech.SUCCESS){

          val result = tts!!.setLanguage(Locale.US)

          if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){

              Log.e("tts","language not supported or missing data")
          }
      }else{

          Log.e("tts","Text to speech not instaled ")
      }
    }


    private fun speakOut (text:String){

        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")

    }

private fun setexerciserecycleview (){

    recycle.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    exerciseadapter = exercise_statuse_adapter(this,exerciselist!!)
    recycle.adapter = exerciseadapter

    }
}