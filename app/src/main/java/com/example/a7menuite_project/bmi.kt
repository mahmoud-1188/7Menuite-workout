package com.example.a7menuite_project

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_bmi.*

class bmi : AppCompatActivity(),TextWatcher {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        heightedit.addTextChangedListener(this)
        weightedit.addTextChangedListener(this)

        setSupportActionBar(bmitoolbare)

        val actionbare = supportActionBar
            actionbare?.title = "Calculator"
        if (actionbare != null){

            actionbare.setDisplayHomeAsUpEnabled(true)
        }

        bmitoolbare.setNavigationOnClickListener {
            onBackPressed()
        }

       makevisablemetricalunitview()
        radio_group.setOnCheckedChangeListener { radioGroup, i ->

            if (i == R.id.metric_unit){
                makevisablemetricalunitview()
            }else{
                makevisableusunitview()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun bmi_calcolate_us (){

        val weight_lbs = lbstxt.text.toString()
        val  feettxt = feettxt.text.toString()
        val  inchtxt = inchtxt.text.toString()

        val inches = feettxt.toInt() * 12
        val inchessum = (inches + inchtxt.toInt())

       val bmi_calc = weight_lbs.toFloat() / (inchessum * inchessum).toFloat()
       val bmi = 703 * bmi_calc

        val bmiconvert = "%.1f".format(bmi)
        bmi_ritio.text = bmiconvert

        if (bmi < 18.5) {
            bmi_normal.text = "Skinny"
            bmi_cong.text = "Your body is underweight, consult your doctor!"

        } else if (bmi > 18.5 && bmi < 25) {
            bmi_normal.text = "normal"
            bmi_cong.text = "Congratulations! You are in a good shape!"
        } else {

            bmi_normal.text = "overweight"
            bmi_cong.text = "Your body is overweight, consult your doctor!"
        }

        llresult.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun bmi_calculate_metrical () {


        val bmi_weight = weightedit.text.toString()
        val bmi_height = heightedit.text.toString()

        val height_parsent = (bmi_height.toFloatOrNull()!!.div(100))
        val bmi = bmi_weight.toInt().div(height_parsent * 2)
        val bmiconvert = "%.1f".format(bmi)
        bmi_ritio.text = bmiconvert


        if (bmi < 18.5) {
            bmi_normal.text = "Skinny"
            bmi_cong.text = "Your body is underweight, consult your doctor!"

        } else if (bmi > 18.5 && bmi < 25) {
            bmi_normal.text = "normal"
            bmi_cong.text = "Congratulations! You are in a good shape!"
        } else {

            bmi_normal.text = "overweight"
            bmi_cong.text = "Your body is overweight, consult your doctor!"
        }

        llresult.visibility = View.VISIBLE
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        llresult.visibility = View.INVISIBLE
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    private fun makevisableusunitview(){

        weighteditkg.visibility = View.GONE
        heighteditcm.visibility = View.GONE
        weight_lbs.visibility = View.VISIBLE
        feet_layout.visibility = View.VISIBLE
        feettxt.text!!.clear()
        inchtxt.text!!.clear()
        lbstxt.text!!.clear()
        llresult.visibility = View.INVISIBLE

        val weight_lbs = lbstxt.text
        val  feettx = feettxt.text
        val  inchtx = inchtxt.text

        bmi_btn.setOnClickListener {

            if (weight_lbs.toString().isEmpty() || weight_lbs.toString().toInt().compareTo(30) <=0 || weight_lbs.toString().toInt().compareTo(1000) >=0){
                lbstxt.error = "pleas enter a valid weight!"
                return@setOnClickListener
            }
            if (feettx.toString().isEmpty() || feettx.toString().toInt().compareTo(2) <=0 || feettx.toString().toInt().compareTo(8) >=0  ){
                feettxt.error = "pleas enter a valid feet number!"
                return@setOnClickListener
            }
            if (inchtx.toString().isEmpty() || inchtx.toString().toInt().compareTo(0) < 0 || inchtx.toString().toInt().compareTo(12) > 0  ){
                inchtxt.error = "pleas enter a valid inch! number"
                return@setOnClickListener
            }

            bmi_calcolate_us()
        }
    }
    private fun makevisablemetricalunitview (){

            weight_lbs.visibility = View.GONE
            feet_layout.visibility = View.GONE
            weighteditkg.visibility = View.VISIBLE
            heighteditcm.visibility = View.VISIBLE
            weightedit.text!!.clear()
            heightedit.text!!.clear()
            llresult.visibility = View.INVISIBLE

        val  bmiweight1 = weightedit.text
        val  bmiheight1 = heightedit.text


        bmi_btn.setOnClickListener {

            if (bmiweight1.toString().isEmpty() || bmiweight1.toString().toInt().compareTo(24) <=0 || bmiweight1.toString().toInt().compareTo(500) >=0){
                weightedit.error = "pleas enter a valid weight!"
                return@setOnClickListener
            }
            if (bmiheight1.toString().isEmpty() || bmiheight1.toString().toInt().compareTo(100) <=0 || bmiheight1.toString().toInt().compareTo(220) >=0  ){
                heightedit.error = "pleas enter a valid height!"
                return@setOnClickListener
            }

            bmi_calculate_metrical()
        }

    }

    // make keyword hide...
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }
}


