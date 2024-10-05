package com.example.topicos_previo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var theoryHours : Int = 0
    private var practicesHours : Int = 0

    private lateinit var editextMateria: EditText
    private lateinit var etCreditos: EditText
    private lateinit var calculate: Button
    private lateinit var tvHorasTeorica: TextView
    private lateinit var buttonHTRemove: FloatingActionButton
    private lateinit var buttonHTAdd: FloatingActionButton

    private lateinit var tvHorasPractica: TextView
    private lateinit var buttonHPRemove: FloatingActionButton
    private lateinit var buttonHPAdd: FloatingActionButton

    var nameSubject: String = ""
    var credits: String = ""
    var hoursTheories: Int = 0
    var hoursPractices: Int = 0
    var hoursCredits: Int = 0
    var hoursPresencial: Int = 0
    var independentWork: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponent()
        initListener()
        initUI()
        onClickInButton()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun clearData() {
        tvHorasTeorica.text = "0"
        tvHorasPractica.text = "0"
        editextMateria.text.clear()
        etCreditos.text.clear()
    }

    private fun onClickInButton() {
        calculate.setOnClickListener {
            continueProcess()
        }
    }

    private fun continueProcess() {
        try {
            nameSubject = editextMateria.text.toString()
            credits = etCreditos.text.toString()
            hoursTheories = theoryHours
            hoursPractices = practicesHours
            hoursCredits = 0
            hoursPresencial = 0
            independentWork = 0

            if (nameSubject.isEmpty() && credits.isEmpty())
                Toast.makeText(this, "Por ingrese los datos", Toast.LENGTH_SHORT).show()
            else if (nameSubject.isEmpty())
                Toast.makeText(this, "Por favor ingrese nombre de la materia", Toast.LENGTH_SHORT).show()
            else if (credits.isEmpty())
                Toast.makeText(this, "Por favor ingrese numero de creditos", Toast.LENGTH_SHORT).show()
            else {
                hoursCredits = (credits.toInt() * 48)
                hoursPresencial = (hoursTheories + hoursPractices) * 16
                independentWork = (hoursCredits - hoursPresencial) / 16
                nextView()
            }
        } catch (e: ArithmeticException) {
            Toast.makeText(this, "Error en el calculo", Toast.LENGTH_SHORT)
        }
    }

    private fun nextView() {
        val intent = Intent(this, showInformation::class.java)
        intent.putExtra("nameSubject", nameSubject)
        intent.putExtra("credits", credits)
        intent.putExtra("hoursPresencial", hoursPresencial.toString())
        intent.putExtra("independentWork", independentWork.toString())
        intent.putExtra("hoursPractices", hoursPractices.toString())
        intent.putExtra("hoursTheories", hoursTheories.toString())
        startActivity(intent)
        clearData()
    }

    private fun initComponent() {
        tvHorasTeorica = findViewById(R.id.tvHorasTeorica)
        buttonHTRemove = findViewById(R.id.buttonHTRemove)
        buttonHTAdd = findViewById(R.id.buttonHTAdd)

        tvHorasPractica = findViewById(R.id.tvHorasPractica)
        buttonHPRemove = findViewById(R.id.buttonHPRemove)
        buttonHPAdd = findViewById(R.id.buttonHPAdd)

        editextMateria = findViewById(R.id.editextMateria)
        etCreditos = findViewById(R.id.etCreditos)
        calculate = findViewById(R.id.calculate)
    }

    private fun initListener() {
        buttonHTAdd.setOnClickListener {
            theoryHours += 1
            setHT()
        }

        buttonHTRemove.setOnClickListener {
            if (theoryHours >= 1) {
                theoryHours -= 1
                setHT()
            }
        }

        buttonHPAdd.setOnClickListener {
            practicesHours += 1
            setHP()
        }

        buttonHPRemove.setOnClickListener {
            if (practicesHours >= 1) {
                practicesHours -= 1
                setHP()
            }
        }
    }

    private fun setHT() {
        tvHorasTeorica.text = theoryHours.toString()
    }

    private fun setHP() {
        tvHorasPractica.text = practicesHours.toString()
    }

    private fun initUI() {
        setHT()
        setHP()
    }
}