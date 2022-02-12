package ru.netology.pet_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.databinding.ActivityVariant1Binding
import ru.netology.pet_app.viewmodel.PostViewModel
import java.io.File


class Variant1Activity : AppCompatActivity() {
    val viewModel: PostViewModel by viewModels()
    val type = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityVariant1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = getIntent()


        var task: YorTaskVariant

        val id = viewModel.getIdVariant(type)
        val message = viewModel.getMessageVariantById(id)
        val answer = viewModel.getAnswerVariantById(id)
        val picture = viewModel.getPictureVariantById(id)


       binding.messgae.text = message

        val parsePicture = Uri.parse("android.resource://ru.netology.pet_app/drawable/$picture")

        Glide
            .with(this)
            .load(parsePicture)
            .into(binding.image)

        binding.next.setOnClickListener {

            viewModel.saveTaskVariant(YorTaskVariant(id,type,message,answer,binding.answer.text.toString(),picture,1))
            viewModel.setDecidedVariantById(id)
            if (viewModel.sizeSaveTask() == 2) {
                val intentResult: Intent = Intent(this, ResultVariantActivity::class.java)
                viewModel.removeDecidedVariant(type)
                finish()
                startActivity(intentResult)
            } else {
                finish()
                startActivity(intent)
            }

        }
    }
    override fun onBackPressed() {
        viewModel.deleteVariant()
        viewModel.removeDecidedVariant(type)
        super.onBackPressed()
    }

}