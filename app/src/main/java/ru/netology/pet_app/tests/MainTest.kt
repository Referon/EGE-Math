package ru.netology.pet_app.tests

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.netology.pet_app.AndroidUtils
import ru.netology.pet_app.MyDialogFragment
import ru.netology.pet_app.databinding.MainTestsLayoutBinding
import ru.netology.pet_app.viewmodel.PostViewModel

abstract class MainTest(open val type: Int): AppCompatActivity() {
    open val viewModel: PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = MainTestsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()

        if (viewModel.getSize(type) <= 0) {
            viewModel.resetAllDecided()
        }
        val activity = this

        val id = viewModel.getId(type)
        val picture = viewModel.getPictureById(id)

        val parsePicture = Uri.parse("android.resource://ru.netology.pet_app/drawable/$picture")

        Glide
            .with(this)
            .load(parsePicture)
            .apply(RequestOptions().override(800, 800))
            .into(binding.image)

        with(binding) {
            messgae.setMovementMethod(ScrollingMovementMethod())
            messgae.text = viewModel.getMessageById(id)


            val intent: Intent = getIntent()
            result.setOnClickListener {
                if (answer.text.toString() == viewModel.getAnswerById(id)) {

                    val myDialogFragment = MyDialogFragment()
                    val manager = supportFragmentManager
                    MyDialogFragment.newInstance(
                        "Решение верно",
                        "Правильный ответ: ${answer.text}",
                        activity
                    )
                        .show(manager,"myDialog")

                    viewModel.setDecidedById(id)
                    AndroidUtils.hideKeyboard(it)

                }
                if (answer.text.toString() != viewModel.getAnswerById(id)) {

                    val myDialogFragment = MyDialogFragment()
                    val manager = supportFragmentManager
                    MyDialogFragment.newInstance(
                        "Решение не верно",
                        "Правильный ответ:${viewModel.getAnswerById(id)}",
                        activity
                    )
                        .show(manager,"myDialog")

                    AndroidUtils.hideKeyboard(it)
                }
            }

        }
    }
}