package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var resultView: TextView
    private var result = ""
    private lateinit var numbers: Array<Int>
    private lateinit var operations: Array<Int>
    private var number: Int = 0
    private var operation: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultView = findViewById<TextView>(R.id.result)
        resultView.text = result
        operations = arrayOf(R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv,R.id.btnEquals,R.id.btnClear,R.id.btnClearAll)
        numbers= arrayOf(R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9)
        for (btn in numbers) {
            var button = findViewById<Button>(btn)
            button.setOnClickListener {numberClick(button)}
        }
        for (btn in operations) {
            var button = findViewById<Button>(btn)
            button.setOnClickListener {operationClick(button)}
        }
    }
    private fun numberClick(btn: Button) {
        result+=(btn.text)
        resultView.text=result
    }
    private fun operationClick(btn: Button) {
        if (result != "") {
            when (operation) {
                "add" -> number += result.toInt()
                "sub" -> number -= result.toInt()
                "div" -> { if (result.toInt() != 0) {
                    number /= result.toInt()}
                }
                "mul" -> number *= result.toInt()
                "" -> number = result.toInt()
            }
        }
        when (btn.text) {
            "+" -> operation="add"
            "-" -> operation="sub"
            "/" -> operation="div"
            "x" -> operation="mul"
            "=" -> {result = number.toString()
                operation=""}
            "C" -> result= result.dropLast(1)
            "AC" -> operation=""
        }
        if (btn.text != "C" && btn.text != "=") {
            result = ""
        }
        resultView.text = result

    }
    
}