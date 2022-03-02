package ru.netology.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import ru.netology.pet_app.tests.*

class TestsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tests)
    }

    fun test1(view: View) {
        val operationOne = Intent(this, Test1::class.java)
        startActivity(operationOne)
    }
    fun test2(view: View) {
        val test2 = Intent(this, Test2::class.java)
        startActivity(test2)
    }
    fun test3(view: View) {
        val test3 = Intent(this, Test3::class.java)
        startActivity(test3)
    }
    fun test4(view: View) {
        val test4 = Intent(this, Test4::class.java)
        startActivity(test4)
    }
    fun test5(view: View) {
        val test5 = Intent(this, Test5::class.java)
        startActivity(test5)
    }
    fun test6(view: View) {
        val test6 = Intent(this, Test6::class.java)
        startActivity(test6)
    }
    fun test7(view: View) {
        val test7 = Intent(this, Test7::class.java)
        startActivity(test7)
    }
    fun test8(view: View) {
        val test8 = Intent(this, Test8::class.java)
        startActivity(test8)
    }
    fun test9(view: View) {
        val test9 = Intent(this, Test9::class.java)
        startActivity(test9)
    }
    fun test10(view: View) {
        val test10 = Intent(this, Test10::class.java)
        startActivity(test10)
    }
    fun test11(view: View) {
        val test11 = Intent(this, Test11::class.java)
        startActivity(test11)
    }

}