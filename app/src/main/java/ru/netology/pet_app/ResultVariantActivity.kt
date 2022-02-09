package ru.netology.pet_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.pet_app.adapter.OnInteractionListener
import ru.netology.pet_app.adapter.PostsAdapter
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.databinding.ActivityResultVariantBinding
import ru.netology.pet_app.viewmodel.PostViewModel

class ResultVariantActivity : AppCompatActivity() {
    val viewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultVariantBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val adapter = PostsAdapter(object : OnInteractionListener {

            override fun setAnswer(task: YorTaskVariant) {

            }
        })

        binding.list.adapter = adapter

        viewModel.data.observe(this) {task ->

            adapter.submitList(task)
        }
    }
    override fun onBackPressed() {
        viewModel.deleteVariant()
        super.onBackPressed()
    }
}