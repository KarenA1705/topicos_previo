package com.example.topicos_previo

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var theoryHours : Int = 0
    private var practicesHours : Int = 0

    private lateinit var tvHorasTeorica : TextView
    private lateinit var buttonHTRemove : FloatingActionButton
    private lateinit var buttonHTAdd : FloatingActionButton

    private lateinit var tvHorasPractica : TextView
    private lateinit var buttonHPRemove:  FloatingActionButton
    private lateinit var buttonHPAdd : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initComponent()
        initListener()
        initUI()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponent(){
        tvHorasTeorica = findViewById(R.id.tvHorasTeorica)
        buttonHTRemove = findViewById(R.id.buttonHTRemove)
        buttonHTAdd =  findViewById(R.id.buttonHTAdd)

        tvHorasPractica = findViewById(R.id.tvHorasPractica)
        buttonHPRemove = findViewById(R.id.buttonHPRemove)
        buttonHPAdd = findViewById(R.id.buttonHPAdd)
    }

    private fun initListener(){
        buttonHTAdd.setOnClickListener {
            theoryHours += 1
            setHT()
        }

        buttonHTRemove.setOnClickListener {
            if(theoryHours >= 1){
                theoryHours -= 1
                setHT()
            }
        }

        buttonHPAdd.setOnClickListener{
            practicesHours += 1
            setHP()
        }

        buttonHPRemove.setOnClickListener{
            if( practicesHours >= 1){
                practicesHours -= 1
                setHP()
            }
        }
    }

    private fun setHT (){
        tvHorasTeorica.text = theoryHours.toString()
    }

    private fun setHP(){
        tvHorasPractica.text = practicesHours.toString()
    }

    private fun initUI(){
        setHT()
        setHP()
    }
}