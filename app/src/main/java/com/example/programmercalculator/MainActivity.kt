package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.programmercalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        addCallBacks()
    }

    private fun addCallBacks() {
        binding.decimalInput.editText!!.addTextChangedListener { text ->
            if (binding.decimalInput.editText!!.isFocused && text.toString().isNotEmpty()) {

                val values = convertFromDecimal(text.toString())
                updateValues(NumberSystems.DEC, values)

            } else if (binding.decimalInput.editText!!.isFocused) {

                clearFields()

            }
        }

        binding.binaryInput.editText!!.addTextChangedListener { text ->
            if (binding.binaryInput.editText!!.isFocused && text.toString().isNotEmpty()) {

                val values = convertFromBinary(text.toString())
                updateValues(NumberSystems.BIN, values)

            } else if (binding.binaryInput.editText!!.isFocused) {

                clearFields()

            }
        }

        binding.octalInput.editText!!.addTextChangedListener { text ->
            if (binding.octalInput.editText!!.isFocused && text.toString().isNotEmpty()) {

                val values = convertFromOctal(text.toString())
                updateValues(NumberSystems.OCTAL, values)

            } else if (binding.octalInput.editText!!.isFocused) {

                clearFields()

            }
        }

        binding.hexadecimalInput.editText!!.addTextChangedListener { text ->
            if (binding.hexadecimalInput.editText!!.isFocused && text.toString().isNotEmpty()) {

                val values = convertFromHexadecimal(text.toString())
                updateValues(NumberSystems.HEX, values)

            } else if (binding.hexadecimalInput.editText!!.isFocused) {

                clearFields()

            }
        }


        binding.clear.setOnClickListener {
            clearFields()
        }
    }


    private fun convertFromHexadecimal(hexadecimalString: String): List<String> {
        val decimalValue = hexadecimalString.toBigInteger(16).toString()
        val binaryValue = hexadecimalString.toBigInteger(16).toString(2)
        val octalValue = hexadecimalString.toBigInteger(16).toString(8)

        return listOf(decimalValue, binaryValue, octalValue)
    }

    private fun convertFromOctal(octalString: String): List<String> {
        val decimalValue = octalString.toBigInteger(8).toString()
        val binaryValue = octalString.toBigInteger(8).toString(2)
        val hexadecimalValue = octalString.toBigInteger(8).toString(16).uppercase()

        return listOf(decimalValue, binaryValue, hexadecimalValue)
    }

    private fun convertFromBinary(binaryString: String): List<String> {
        val decimalValue = binaryString.toBigInteger(2).toString()
        val octalValue = binaryString.toBigInteger(2).toString(8)
        val hexadecimalValue = binaryString.toBigInteger(2).toString(16).uppercase()

        return listOf(decimalValue, octalValue, hexadecimalValue)

    }

    private fun convertFromDecimal(decimalString: String): List<String> {
        val binaryValue = decimalString.toBigInteger().toString(2)
        val octalValue = decimalString.toBigInteger().toString(8)
        val hexadecimalValue = decimalString.toBigInteger().toString(16).uppercase()

        return listOf(binaryValue, octalValue, hexadecimalValue)

    }


    private fun clearFields() {
        binding.decimalInput.editText?.text!!.clear()
        binding.binaryInput.editText!!.text.clear()
        binding.octalInput.editText!!.text.clear()
        binding.hexadecimalInput.editText!!.text.clear()
    }

    private fun updateValues(valueFrom: NumberSystems, values: List<String>) {
        when (valueFrom) {
            NumberSystems.DEC -> {
                binding.binaryInput.editText!!.setText(values[0])
                binding.octalInput.editText!!.setText(values[1])
                binding.hexadecimalInput.editText!!.setText(values[2])
            }
            NumberSystems.BIN -> {
                binding.decimalInput.editText!!.setText(values[0])
                binding.octalInput.editText!!.setText(values[1])
                binding.hexadecimalInput.editText!!.setText(values[2])
            }
            NumberSystems.OCTAL -> {
                binding.decimalInput.editText!!.setText(values[0])
                binding.binaryInput.editText!!.setText(values[1])
                binding.hexadecimalInput.editText!!.setText(values[2])
            }
            NumberSystems.HEX -> {
                binding.decimalInput.editText!!.setText(values[0])
                binding.binaryInput.editText!!.setText(values[1])
                binding.octalInput.editText!!.setText(values[2])
            }
        }

    }


}