package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var result: TextView
    private  var operand: Double = 0.0
    private var operation: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.TEXT)
    }

    fun numClick(clicked:View){
        if(clicked is TextView){
            var num = clicked.text.toString()
            var res = result.text.toString()

            if(res == "0"){
                res = ""
            }

            result.text = res+num
        }
    }


    fun operationClick(clicked: View){
        if(clicked is TextView){
            operand = result.text.toString().toDouble()
            operation = clicked.text.toString()
            result.text = ""
        }
    }

    fun equals(clicked: View){
        if(clicked is TextView){
            val sc = result.text.toString().toDouble()
            when(operation){
                "+"->result.text = (operand+sc).toString()
                "-"->result.text = (operand-sc).toString()
                "%"->result.text = (operand*sc/100).toString()
                "/"->result.text = (operand/sc).toString()
            }
        }
    }
    fun clearClick(clicked: View){
        if(clicked is TextView){
            result.text = "0";
        }
    }

    fun dotclick(clicked : View){
        if(clicked is TextView){
            var a = result.text.toString()
            if(a.indexOf(".")==-1){
                result.text = a+"."
            }

        }
    }
}