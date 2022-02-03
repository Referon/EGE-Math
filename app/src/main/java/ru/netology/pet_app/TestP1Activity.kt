package ru.netology.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import ru.netology.pet_app.databinding.ActivityTestP1Binding
import ru.netology.pet_app.viewmodel.PostViewModel

class TestP1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_p1)

        val binding = ActivityTestP1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()

        if (viewModel.getSize() <= 0) {
            viewModel.resetAllDecided()
        }

        val id = viewModel.getId()

        with(binding) {
            group.visibility = View.INVISIBLE
            messgae.text = viewModel.getMessageById(id)

            val intent: Intent = getIntent()
            result.setOnClickListener {
                if (answer.text.toString() == viewModel.getAnswerById(id)) {

                    val myDialogFragment = MyDialogFragment()
                    val manager = supportFragmentManager
                    MyDialogFragment.newInstance("Решение верно", "Правильный ответ: ${answer.text}",this@TestP1Activity)
                        .show(manager,"myDialog")

                    viewModel.setDecidedById(id)
                    AndroidUtils.hideKeyboard(it)
                    group.visibility = View.VISIBLE

                }
                if (answer.text.toString() != viewModel.getAnswerById(id)) {

                    val myDialogFragment = MyDialogFragment()
                    val manager = supportFragmentManager
                    MyDialogFragment.newInstance("Решение не верно", "Правильный ответ:${viewModel.getAnswerById(id)}", this@TestP1Activity)
                        .show(manager,"myDialog")

                    AndroidUtils.hideKeyboard(it)
                    group.visibility = View.VISIBLE
                }
            }
            next.setOnClickListener {
                finish()
                startActivity(intent)
            }

        }
    }
}