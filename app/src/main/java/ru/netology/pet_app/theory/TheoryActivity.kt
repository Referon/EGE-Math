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

    fun theory1(view: View) {
        val theory1 = Intent(this, Theory1::class.java)
        startActivity(theory1)
    }
    fun theory2(view: View) {
        val theory2 = Intent(this, Theory2::class.java)
        startActivity(theory2)
    }
    fun theory3(view: View) {
        val theory3 = Intent(this, Theory3::class.java)
        startActivity(theory3)
    }
    fun theory4(view: View) {
        val theory4 = Intent(this, Theory4::class.java)
        startActivity(theory4)
    }
    fun theory5(view: View) {
        val theory5 = Intent(this, Theory5::class.java)
        startActivity(theory5)
    }
    fun theory6(view: View) {
        val theory6 = Intent(this, Theory6::class.java)
        startActivity(theory6)
    }
    fun theory7(view: View) {
        val theory7 = Intent(this, Theory7::class.java)
        startActivity(theory7)
    }
    fun theory8(view: View) {
        val theory8 = Intent(this, Theory8::class.java)
        startActivity(theory8)
    }
    fun theory9(view: View) {
        val theory9 = Intent(this, Theory9::class.java)
        startActivity(theory9)
    }
    fun theory10(view: View) {
        val theory10 = Intent(this, Theory10::class.java)
        startActivity(theory10)
    }
    fun theory11(view: View) {
        val theory11 = Intent(this, Theory11::class.java)
        startActivity(theory11)
    }


}