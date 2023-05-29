package com.example.practicapreexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class ReciboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibo)

        val textView = findViewById<TextView>(R.id.nombref)

        val userInput = intent.getStringExtra("nombre")
        textView.text = userInput



        val numeroReciboEditText = findViewById<EditText>(R.id.numeroReciboEditText)
        val nombreEditText = findViewById<EditText>(R.id.nombreEditText)
        val horasNormalesEditText = findViewById<EditText>(R.id.horasNormalesEditText)
        val horasExtraEditText = findViewById<EditText>(R.id.horasExtraEditText)
        val puestoRadioGroup = findViewById<RadioGroup>(R.id.puestoRadioGroup)
        val calcularButton = findViewById<Button>(R.id.calcularButton)
        val limpiarButton = findViewById<Button>(R.id.LimpiarButton)
        val regresarButton = findViewById<Button>(R.id.RegresarButton)

        val subtotalEditText = findViewById<EditText>(R.id.subtotalEditText).apply {
            isFocusable = false
            isClickable = false
        }

        val impuestoEditText = findViewById<EditText>(R.id.impuestoEditText).apply {
            isFocusable = false
            isClickable = false
        }

        val totalEditText = findViewById<EditText>(R.id.totalEditText).apply {
            isFocusable = false
            isClickable = false
        }

        calcularButton.setOnClickListener {
            if (numeroReciboEditText.text.isNotEmpty() &&
                nombreEditText.text.isNotEmpty() &&
                horasNormalesEditText.text.isNotEmpty() &&
                horasExtraEditText.text.isNotEmpty() &&
                puestoRadioGroup.checkedRadioButtonId != -1) {

                val numeroRecibo = numeroReciboEditText.text.toString().toInt()
                val nombre = nombreEditText.text.toString()
                val horasTrabajadasNormales = horasNormalesEditText.text.toString().toDouble()
                val horasTrabajadasExtra = horasExtraEditText.text.toString().toDouble()
                val puesto = when (puestoRadioGroup.checkedRadioButtonId) {
                    R.id.auxiliarRadioButton -> 1
                    R.id.albanilRadioButton -> 2
                    R.id.ingObraRadioButton -> 3
                    else -> 0
                }

                val recibo = ReciboNomina(horasTrabajadasNormales, horasTrabajadasExtra, puesto)

                recibo.calcularSubtotal()
                recibo.calcularImpuesto()
                recibo.calcularTotal()

                // Actualizar los EditTexts con los valores calculados
                subtotalEditText.setText(recibo.subtotal.toString())
                impuestoEditText.setText(recibo.impuesto.toString())
                totalEditText.setText(recibo.total.toString())

            } else {
                Toast.makeText(this, "Por favor, rellene todos los campos.", Toast.LENGTH_SHORT).show()
            }
        }

        limpiarButton.setOnClickListener {
            numeroReciboEditText.text.clear()
            nombreEditText.text.clear()
            horasNormalesEditText.text.clear()
            horasExtraEditText.text.clear()

            puestoRadioGroup.clearCheck()

            subtotalEditText.text.clear()
            impuestoEditText.text.clear()
            totalEditText.text.clear()
        }
        regresarButton.setOnClickListener {
            finish()
        }


    }
}


