package com.ivanur.peperomia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ivanur.peperomia.firstApp.FirstAppActivity
import com.ivanur.peperomia.imcCalculator.ImcCalculatorActivity
import com.ivanur.peperomia.todoApp.TodoAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODOApp = findViewById<Button>(R.id.btnTODO)
        btnSaludApp.setOnClickListener { navigateToSaludApp() }
        btnImcApp.setOnClickListener { navigateToImcApp() }
        btnTODOApp.setOnClickListener { navigateToTODOApp() }
    }

    private fun navigateToSaludApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp() {
        val intent = Intent(this, TodoAppActivity::class.java)
        startActivity(intent)
    }
}