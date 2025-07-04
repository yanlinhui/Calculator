package com.example.project1calculator

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import checkIfCanAppend
import checkOperatinInput
import java.util.Stack

class MainActivity : AppCompatActivity() {
    private lateinit var details: TextView
    private lateinit var result: TextView

    private val numStack: Stack<Double> = Stack()
    private val operationStack: Stack<String> = Stack()
    private val operationMap: Map<String, Int> = mapOf(
        "+" to 1,
        "-" to 1,
        "×" to 2,
        "÷" to 2
    )

    private val processBuilder = StringBuilder()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        details = findViewById(R.id.tv_process)
        result = findViewById(R.id.tv_result)

        findViewById<TextView>(R.id.tv_clear).setOnClickListener { clickClear(it) }
        findViewById<TextView>(R.id.tv_delete).setOnClickListener { clickDelete(it) }
        findViewById<TextView>(R.id.tv_equal).setOnClickListener { clickEqual(it) }
        findViewById<TextView>(R.id.tv_num0).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num1).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num2).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num3).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num4).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num5).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num6).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num7).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num8).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num9).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_num00).setOnClickListener { clickNumber(it) }
        findViewById<TextView>(R.id.tv_plus).setOnClickListener { clickOperation(it) }
        findViewById<TextView>(R.id.tv_minus).setOnClickListener { clickOperation(it) }
        findViewById<TextView>(R.id.tv_multiple).setOnClickListener { clickOperation(it) }
        findViewById<TextView>(R.id.tv_devide).setOnClickListener { clickOperation(it) }
    }

    fun clickClear(v: View) {
        processBuilder.clear()
        details.text = "0"
        result.text = "0"
    }

    fun clickDelete(v: View) {
        if (!processBuilder.isEmpty()) {
            processBuilder.deleteCharAt(processBuilder.length - 1)
            calculate()
        }
        if (processBuilder.isEmpty()) {
            details.text = "0"
        } else {
            details.text = processBuilder.toString()
        }
    }

    fun clickEqual(v: View) {
        details.text = result.text
    }

    fun clickOperation(v: View) {
        val operator = v.tag as String
        processBuilder.checkOperatinInput(operator)
        details.text = processBuilder.toString()
    }

    fun clickNumber(v: View) {
        val numStr = (v as TextView).text.toString()
        val hasAppend = processBuilder.checkIfCanAppend(numStr)
        if (hasAppend) calculate()
        details.text = processBuilder.toString()
    }

    private fun calculate() {
        val numBuilder = StringBuilder()
        processBuilder.toString().forEachIndexed { i, c ->
            if (c in '0'..'9') {
                numBuilder.append(c)
            } else {
                numStack.push(numBuilder.toString().toDouble())
                val cstr = c.toString()
                while (true) {
                    if (operationStack.isEmpty()) {
                        operationStack.push(cstr)
                        break
                    }
                    val operator = operationStack.peek()
                    if (operationMap[cstr]!! <= operationMap[operator]!!) {
                        val num2 = numStack.pop()
                        val num1 = numStack.pop()
                        perfomCalculate(num1, num2, operator)
                        operationStack.clear()
                    }else{
                        operationStack.push(cstr)
                        break
                    }
                }
                numBuilder.clear()
            }
        }
        if(numBuilder.isNotEmpty()){
            numStack.push(numBuilder.toString().toDouble())
        }
        if (numStack.size == operationStack.size){
            operationStack.pop()
        }
        while (operationStack.isNotEmpty()){
            val num2 = numStack.pop()
            val num1 = numStack.pop()
            val operation = operationStack.pop()
            perfomCalculate(num1,num2,operation)
        }
        result.text = numStack.pop().toString()
        numStack.clear()
        operationStack.clear()
    }

    private fun perfomCalculate(num1: Double, num2: Double, operator: String) {
        when (operator) {
            "+" -> numStack.push(num1 + num2)
            "-" -> numStack.push(num1 - num2)
            "×" -> numStack.push(num1 * num2)
            "÷" -> numStack.push(num1 / num2)
        }

    }
}