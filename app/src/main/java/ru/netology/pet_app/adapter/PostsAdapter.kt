package ru.netology.pet_app.adapter

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import ru.netology.pet_app.R
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.databinding.ResultVariantBinding

interface OnInteractionListener {
    fun setAnswer(task: YorTaskVariant) {}
}


class PostsAdapter (
    private val callback: OnInteractionListener

    ) : androidx.recyclerview.widget.ListAdapter<YorTaskVariant, PostViewHolder>(PostDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ResultVariantBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding,callback)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }


}


class PostViewHolder(
    private val binding: ResultVariantBinding,
    private val callback: OnInteractionListener,
): RecyclerView.ViewHolder(binding.root) {


    fun bind (task: YorTaskVariant) {
        val picture = task.picture
        binding.apply {
            message.text = task.message
            answer.text = "Правильный ответ: ${task.answer}"
            yorAnswer.text = "Ваш ответ: ${task.yourAnswer}"

            val parsePicture = Uri.parse("android.resource://ru.netology.pet_app/drawable/$picture")
            Glide.with(itemView)
                .load(parsePicture)
                .apply(RequestOptions().override(800, 800))
                .into(pictures)

        }
    }
}

class PostDiffCallback: DiffUtil.ItemCallback<YorTaskVariant>() {
    override fun areItemsTheSame(oldItem: YorTaskVariant, newItem: YorTaskVariant): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: YorTaskVariant, newItem: YorTaskVariant): Boolean {
        return oldItem == newItem
    }

}

