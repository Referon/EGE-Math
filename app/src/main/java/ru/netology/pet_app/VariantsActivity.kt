package ru.netology.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.netology.pet_app.variants.*

class VariantsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_variants)
    }
    fun variant1(view: View) {
        val variant = Intent(this, Variant1::class.java)
        startActivity(variant)
    }
    fun variant2(view: View) {
        val variant2 = Intent(this, Variant2::class.java)
        startActivity(variant2)
    }
    fun variant3(view: View) {
        val variant3 = Intent(this, Variant3::class.java)
        startActivity(variant3)
    }
    fun variant4(view: View) {
        val variant4 = Intent(this, Variant4::class.java)
        startActivity(variant4)
    }
    fun variant5(view: View) {
        val variant5 = Intent(this, Variant5::class.java)
        startActivity(variant5)
    }
    fun variant6(view: View) {
        val variant6 = Intent(this, Variant6::class.java)
        startActivity(variant6)
    }
    fun variant7(view: View) {
        val variant7 = Intent(this, Variant7::class.java)
        startActivity(variant7)
    }
    fun variant8(view: View) {
        val variant8 = Intent(this, Variant8::class.java)
        startActivity(variant8)
    }
    fun variant9(view: View) {
        val variant9 = Intent(this, Variant9::class.java)
        startActivity(variant9)
    }
    fun variant10(view: View) {
        val variant10 = Intent(this, Variant10::class.java)
        startActivity(variant10)
    }
}