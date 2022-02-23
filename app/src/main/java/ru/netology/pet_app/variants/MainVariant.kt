package ru.netology.pet_app.variants

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.netology.pet_app.ResultVariantActivity
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.databinding.MainVariantsLayoutBinding
import ru.netology.pet_app.viewmodel.PostViewModel

abstract class MainVariant(open val type: Int): AppCompatActivity() {
   open val viewModel: PostViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding = MainVariantsLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent: Intent = getIntent()

        var task: YorTaskVariant

        val id = viewModel.getIdVariant(type)
        val message = viewModel.getMessageVariantById(id)
        val answer = viewModel.getAnswerVariantById(id)
        val picture = viewModel.getPictureVariantById(id)

        binding.messgae.setMovementMethod(ScrollingMovementMethod())

        binding.messgae.text = message


            val parsePicture = Uri.parse("android.resource://ru.netology.pet_app/drawable/$picture")


            Glide
                .with(this)
                .load(parsePicture)
                .apply(RequestOptions().override(800, 800))
                .into(binding.image)


        binding.next.setOnClickListener {

            viewModel.saveTaskVariant(YorTaskVariant(id,type,message,answer,binding.answer.text.toString(),picture,1))
            viewModel.setDecidedVariantById(id)
            if (viewModel.sizeSaveTask() == 11) {
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