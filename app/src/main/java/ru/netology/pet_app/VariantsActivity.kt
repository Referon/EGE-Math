package ru.netology.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class VariantsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_variants)
    }
    fun variant1Activity(view: View) {
        val variant = Intent(this, Variant1Activity::class.java)
        startActivity(variant)
    }
}