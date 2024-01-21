package com.ivanur.peperomia.imcCalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ivanur.peperomia.R
import com.ivanur.peperomia.imcCalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {
    private lateinit var tvResult: TextView
    private lateinit var tvImc: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnRecalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initComponents() {
        tvImc = findViewById(R.id.tvImc)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }

    private fun initUI(result: Double) {
        tvImc.text = result.toString()
        when(result){
            // bajo peso
            in 0.00..18.50 -> {
                tvResult.text = getString(R.string.title_low_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescription.text = getString(R.string.description_low_weight)
            }
            // peso normal
            in 18.51..24.99 -> {
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))
                tvDescription.text = getString(R.string.description_normal_weight)
            }
            // sobrepeso
            in 25.00..29.99 -> {
                tvResult.text = getString(R.string.title_high_weight)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.description_high_weight)
            }
            // obesidad
            in 30.00..99.00 -> {
                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescription.text = getString(R.string.description_obesity)
            }
            else -> {
                tvResult.text = getString(R.string.error)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvImc.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

}