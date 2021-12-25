package com.example.membuataplikasikalkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    companion object{
       private const val STATE_RESULT = "state_result"
    }
    private lateinit var edtNumberOne: EditText
    private lateinit var edtNumberTwo: EditText
    private lateinit var tvResult: TextView
    private lateinit var buttonPlus: Button
    private lateinit var buttonMinus: Button
    private lateinit var buttonDivision: Button
    private lateinit var buttonMultiplication: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtNumberOne = findViewById(R.id.edt_numberone)
        edtNumberTwo = findViewById(R.id.edt_numbertwo)

        tvResult = findViewById(R.id.tvResult)

        buttonPlus = findViewById(R.id.buttonPlus)
        buttonMinus = findViewById(R.id.buttonMinus)
        buttonMultiplication = findViewById(R.id.buttonMultiplication)
        buttonDivision = findViewById(R.id.buttonDivision)


        buttonPlus.setOnClickListener(this)
        buttonMinus.setOnClickListener(this)
        buttonDivision.setOnClickListener(this)
        buttonMultiplication.setOnClickListener(this)

        if(savedInstanceState != null)
        {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvResult.text.toString())
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.buttonPlus -> {
                val inputNumberOne = edtNumberOne.text.toString().trim()
                val inputNumberTwo = edtNumberTwo.text.toString().trim()

                var isEmptyFields = false
                if (inputNumberOne.isEmpty()) {
                    isEmptyFields = true
                    edtNumberOne.error = "Field ini tidak boleh dikosongkan"
                }
                if(inputNumberTwo.isEmpty()){
                    isEmptyFields = true
                    edtNumberTwo.error = "field ini tidak boleh dikosongkan"
                }

                if (!isEmptyFields){
                    val numberPlus = inputNumberOne.toDouble() + inputNumberTwo.toDouble()
                    tvResult.text = numberPlus.toString()
                }

            }
            R.id.buttonMinus -> {
                val inputNumberOneForMinus = edtNumberOne.text.toString().trim()
                val inputNumberTwoForMinus = edtNumberTwo.text.toString().trim()

                var isEmptyFields = false

                if(inputNumberOneForMinus.isEmpty()){
                    isEmptyFields = true
                    edtNumberOne.error = "Field Ini tidak bisa dikosongkan !"

                }
                if(inputNumberTwoForMinus.isEmpty()){
                    isEmptyFields = true
                    edtNumberTwo.error = "Field ini tidak bisa dikosongkan!"
                }
                if(!isEmptyFields){
                    val numberMinus = inputNumberOneForMinus.toDouble() - inputNumberTwoForMinus.toDouble()
                    tvResult.text = numberMinus.toString()
                }
            }
            R.id.buttonMultiplication->{
                val inputNumberOneForMultiplication = edtNumberOne.text.toString().trim()
                val inputNumberTwoForMultiplication = edtNumberTwo.text.toString().trim()

                var isEmptyFields = false

                if(inputNumberOneForMultiplication.isEmpty()){
                    isEmptyFields = true
                    edtNumberOne.error = "Field Ini tidak bisa dikosongkan !"

                }
                if(inputNumberTwoForMultiplication.isEmpty()){
                    isEmptyFields = true
                    edtNumberTwo.error = "Field ini tidak bisa dikosongkan !"
                }
                if(!isEmptyFields){
                    val numberMultiplication = inputNumberOneForMultiplication.toDouble() * inputNumberTwoForMultiplication.toDouble()

                    tvResult.text = numberMultiplication.toString()
                }
            }

            R.id.buttonDivision -> {
                val inputNumberOneForDivision = edtNumberOne.text.toString().trim()
                val inputNumberTwoForDivision = edtNumberTwo.text.toString().trim()

                var isEmptyFields = false

                if(inputNumberOneForDivision.isEmpty()){
                    isEmptyFields = true
                    edtNumberOne.error = "Field ini tidak bisa dikosongkan!"

                }
                if(inputNumberTwoForDivision.isEmpty()){
                    isEmptyFields = true
                    edtNumberTwo.error="Field ini tidak bisa dikosongkan!"
                }

                if(!isEmptyFields){
                    val numberDivision = inputNumberOneForDivision.toDouble() / inputNumberTwoForDivision.toDouble()

                    tvResult.text = numberDivision.toString()
                }
            }
        }

    }
}