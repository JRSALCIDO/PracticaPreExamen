package com.example.practicapreexamen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var entrarButton: Button
    private lateinit var salirButton: Button
    private lateinit var totalEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        totalEditText = findViewById(R.id.totalEditText)
        entrarButton = findViewById(R.id.entrarButton)
        salirButton = findViewById(R.id.salirButton)

        entrarButton.setOnClickListener {
            if (totalEditText.text.toString().isNotEmpty()) {
                val intent = Intent(this, ReciboActivity::class.java)
                intent.putExtra("nombre", totalEditText.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor ingrese el nombre del trabajador", Toast.LENGTH_SHORT).show()
            }
        }

        salirButton.setOnClickListener {
            finish()
        }
    }
}
