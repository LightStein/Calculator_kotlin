package com.example.calculator_kotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var operationClicked = false
    private var equalisClicked = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun equalClicked(view: View){
        //  if (textOperation.text.toString().equals("+"))
        //     textFirstArgument.text = (textFirstArgument.text.toString().toDouble() + textSecondArgument.text.toString().toDouble()) as String
        when (textOperation.text.toString()){
            "+" -> textFirstArgument.text = (textFirstArgument.text.toString().toDouble() + textSecondArgument.text.toString().toDouble()).toString()
            "-" -> textFirstArgument.text = (textFirstArgument.text.toString().toDouble() - textSecondArgument.text.toString().toDouble()).toString()
            "x" -> textFirstArgument.text = (textFirstArgument.text.toString().toDouble() * textSecondArgument.text.toString().toDouble()).toString()
            "/" -> textFirstArgument.text = (textFirstArgument.text.toString().toDouble() / textSecondArgument.text.toString().toDouble()).toString()
        }
        textSecondArgument.text = ""
        textOperation.text = ""
        operationClicked = false
        equalisClicked = true
    }

    fun operationClick(view: View){
        if (textFirstArgument.text.isNotEmpty()){
            var button = view as TextView
            operationClicked = true
            textOperation.text = button.text.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun numClick(view: View) {
        var button: TextView = view as TextView
        if (!operationClicked) {

            if (equalisClicked) {
                textFirstArgument.text = ""
                equalisClicked = false
            }
            else{
                btnNegative.setOnClickListener(){
                    textFirstArgument.text = (textFirstArgument.text.toString().toDouble() * (-1)).toString()
                }
            }
            textFirstArgument.text = textFirstArgument.text.toString() + button.text.toString()

        }
        else{
            textSecondArgument.text = textSecondArgument.text.toString() + button.text.toString()

        }
    }

    fun clearClick(view: View){
        var button = view as TextView
        textFirstArgument.text = ""
        textSecondArgument.text = ""
        textOperation.text=""
    }

}