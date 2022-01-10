package ru.netology.pet_app.theory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.netology.pet_app.R

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

    fun operationsWithDegreesActivity(view: View) {
        val operationsWithDegrees = Intent(this, OperationsWithDegrees::class.java)
        startActivity(operationsWithDegrees)
    }
}