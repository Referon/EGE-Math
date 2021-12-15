package ru.netology.pet_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun version(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Версия 0.1", Toast.LENGTH_SHORT)
        myToast.show()

    }

    fun theoryActivity(view: View) {
        val theory = Intent(this, TheoryActivity::class.java)
        startActivity(theory)
    }

    fun formulasActivity(view: View) {
        val formulas = Intent(this, FormulasActivity::class.java)
        startActivity(formulas)
    }

    fun testsActivity(view: View) {
        val tests = Intent(this, TestsActivity::class.java)
        startActivity(tests)
    }
}