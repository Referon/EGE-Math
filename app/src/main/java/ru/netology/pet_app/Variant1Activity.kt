package ru.netology.pet_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.databinding.ActivityVariant1Binding
import ru.netology.pet_app.viewmodel.PostViewModel

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
        val picture = viewModel.getPictureVariantById(1)

       binding.messgae.text = message
        binding.image.setImageResource(R.drawable.pic11 + picture)

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
        viewModel.removeDecidedVariant(type)
        super.onBackPressed()
    }
}