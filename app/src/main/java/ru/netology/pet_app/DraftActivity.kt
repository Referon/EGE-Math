package ru.netology.pet_app

import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.pet_app.databinding.ActivityDraftBinding
import ru.netology.pet_app.viewmodel.PostViewModel

class DraftActivity : AppCompatActivity() {
    private val viewModel: PostViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDraftBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.draftText.setText(viewModel.getDraftMessage())
    }

    override fun onBackPressed() {
        val draftText = findViewById<EditText>(R.id.draft_text)
        viewModel.deleteDraftMessage()
        viewModel.saveDraftMEssage(draftText.text.toString())
        super.onBackPressed()
    }

    override fun onPause() {
        val draftText = findViewById<EditText>(R.id.draft_text)
        viewModel.deleteDraftMessage()
        viewModel.saveDraftMEssage(draftText.text.toString())
        super.onPause()
    }
}