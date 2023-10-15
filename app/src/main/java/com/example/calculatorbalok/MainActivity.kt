package com.example.calculatorbalok

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // declare component view that we use like input text etc
    // declare component input
    private lateinit var editHeight:EditText
    private lateinit var editWidth:EditText
    private lateinit var editLength:EditText

    //declare component button
    private lateinit var btnCalculate:Button

    //declare component result
    private lateinit var calculateResult:TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize component
        // component input
        editHeight = findViewById(R.id.editHeight)
        editWidth = findViewById(R.id.editWidth)
        editLength = findViewById(R.id.editLength)

        // component button
        btnCalculate = findViewById(R.id.btnCalculate)

        // component result
        calculateResult = findViewById(R.id.calculateResult)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            calculateResult.text = result
        }
    }

    override fun onClick(v: View?) {

        if(v?.id == R.id.btnCalculate) {
          val inputLength = editLength.text.toString().trim()
          val inputWidth = editWidth.text.toString().trim()
          val inputHeight = editHeight.text.toString().trim()
          var isEmptyFields = false
          if (inputLength.isEmpty()) {
              isEmptyFields = true
              editLength.error = "field ini tidak boleh kosong"
          }
          if (inputWidth.isEmpty()) {
              isEmptyFields = true
              editWidth.error = "field ini tidak boleh kosong"
          }
          if (inputHeight.isEmpty())  {
              isEmptyFields = true
              editHeight.error = "field ini tidak boleh kosong"
          }
          if(!isEmptyFields) {
              val volumeResult = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
              calculateResult.text = volumeResult.toString()
          }
      }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT , calculateResult.text.toString())
    }

}