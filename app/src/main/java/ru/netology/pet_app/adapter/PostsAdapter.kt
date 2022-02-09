package ru.netology.pet_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.netology.pet_app.data.YorTaskVariant
import ru.netology.pet_app.databinding.CardVariantBinding

interface OnInteractionListener {
    fun setAnswer(task: YorTaskVariant) {}
}


class PostsAdapter (
    private val callback: OnInteractionListener

    ) : androidx.recyclerview.widget.ListAdapter<YorTaskVariant, PostViewHolder>(PostDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardVariantBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostViewHolder(binding,callback)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }


}


class PostViewHolder(
    private val binding: CardVariantBinding,
    private val callback: OnInteractionListener,
): RecyclerView.ViewHolder(binding.root) {


    fun bind (task: YorTaskVariant) {
        binding.apply {
            message.text = task.message
            answer.text = task.answer
            yorAnswer.text = task.yourAnswer

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

