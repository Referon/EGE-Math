package ru.netology.pet_app

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.DialogFragment
import ru.netology.pet_app.viewmodel.PostViewModel

class MyDialogFragment : DialogFragment() {

    private var title: String? = null
    private var message: String? = null
    private var id: Int? = null
    private var activity: Activity? = null
    private var viewModel: PostViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE)
            message = it.getString(ARG_MESSAGE)
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            val arg = arguments
            val builder = AlertDialog.Builder(it)
            builder.setTitle(title)
                .setMessage(message)
                .setIcon(R.drawable.ic_launcher_foreground)
                .setPositiveButton("Далее") {
                        dialog, id ->  updateActivity()
                }
                .setNegativeButton("Пропустить") {
                    dialog, id -> next()
                }
                .setNeutralButton("Назад") {
                        dialog, id -> dialog.cancel()
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun updateActivity() {
        val intent: Intent = Intent(context, activity!!::class.java)
        activity?.finish()
        context?.startActivity(intent)
    }

    fun next() {
        val intent: Intent = Intent(context, activity!!::class.java)
        id?.let { viewModel?.setDecidedById(it) }
        activity?.finish()
        context?.startActivity(intent)
    }




    companion object {
        const val TAG = "myDialog"
        private const val ARG_TITLE = "argTitle"
        private const val ARG_MESSAGE = "argMessage"

        fun newInstance(id1: Int, title: String, message: String, activity1: Activity, viewModel1: PostViewModel) = MyDialogFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_TITLE, title)
                putString(ARG_MESSAGE, message)
                viewModel = viewModel1
                id = id1
                activity = activity1
            }
        }
    }
}