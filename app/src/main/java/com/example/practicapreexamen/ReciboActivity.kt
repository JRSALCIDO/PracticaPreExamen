package com.example.practicapreexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class ReciboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recibo)

        val numeroReciboEditText = findViewById<EditText>(R.id.numeroReciboEditText)
        val nombreEditText = findViewById<EditText>(R.id.nombreEditText)
        val horasNormalesEditText = findViewById<EditText>(R.id.horasNormalesEditText)
        val horasExtraEditText = findViewById<EditText>(R.id.horasExtraEditText)
        val puestoRadioGroup = findViewById<RadioGroup>(R.id.puestoRadioGroup)
        val calcularButton = findViewById<Button>(R.id.calcularButton)

        calcularButton.setOnClickListener {
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

            // Referencia a los EditTexts
            val subtotalEditText = findViewById<EditText>(R.id.subtotalEditText)
            val impuestoEditText = findViewById<EditText>(R.id.impuestoEditText)
            val totalEditText = findViewById<EditText>(R.id.totalEditText)

            // Actualizar los EditTexts con los valores calculados
            subtotalEditText.setText(recibo.subtotal.toString())
            impuestoEditText.setText(recibo.impuesto.toString())
            totalEditText.setText(recibo.total.toString())
        }

    }
}
