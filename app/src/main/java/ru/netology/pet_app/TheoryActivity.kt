package ru.netology.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.TextView

class TheoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theory)

    }

    fun operationWithNumbersActivity(view: View) {
        val operationWithNumbers = Intent(this, OperationsWithNumbers::class.java)
        startActivity(operationWithNumbers)
    }

    fun probabilityTheoryActivity(view: View) {
        val probabilityTheory = Intent(this, ProbabilityTheory::class.java)
        startActivity(probabilityTheory)
    }
}