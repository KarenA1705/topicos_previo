package com.example.topicos_previo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class showInformation : AppCompatActivity() {

    private lateinit var tvNameSubject: TextView
    private lateinit var tvCredits: TextView
    private lateinit var tvHoursPresencial: TextView
    private lateinit var tvIndependentWork: TextView
    private lateinit var tvHoursTheories: TextView
    private lateinit var tvHoursPractices: TextView
    private lateinit var buttonBack: Button

    var nameSubject = ""
    var credits = ""
    var hoursPresencial = ""
    var independentWork = ""
    var hoursTheories = ""
    var hoursPractices = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.information)

        val intent = intent
        nameSubject = intent.getStringExtra("nameSubject").toString()
        credits = intent.getStringExtra("credits").toString()
        hoursPresencial = intent.getStringExtra("hoursPresencial").toString()
        independentWork = intent.getStringExtra("independentWork").toString()
        hoursTheories = intent.getStringExtra("hoursTheories").toString()
        hoursPractices = intent.getStringExtra("hoursPractices").toString()

        initComponent()
        setInformation()
        onClickButton()
    }

    private fun onClickButton() {
        buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun setInformation() {
        tvNameSubject.text = nameSubject
        tvCredits.text = credits
        tvHoursTheories.text = hoursTheories
        tvHoursPractices.text = hoursPractices
        tvHoursPresencial.text = hoursPresencial
        tvIndependentWork.text = independentWork
    }

    private fun initComponent() {
        tvNameSubject = findViewById(R.id.nameSubject)
        tvCredits = findViewById(R.id.credits)
        tvHoursTheories = findViewById(R.id.hoursTheories)
        tvHoursPractices = findViewById(R.id.hoursPractices)
        tvHoursPresencial = findViewById(R.id.hoursPresencial)
        tvIndependentWork = findViewById(R.id.independentWork)
        buttonBack = findViewById(R.id.back)
    }
}