package com.example.tasklists.model

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.hrsalterego.tasklist.R

class FragmentTwo : Fragment() {
    private val viewModel: ListViewModel by activityViewModels()
    private lateinit var taskToEdit: String
    val args: FragmentTwoArgs by navArgs()
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            if (it != null) {
                taskToEdit = it.getString("taskToEdit").toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // val taskToEdit = args.taskToEdit

        view.findViewById<EditText>(R.id.buttonF2).setOnClickListener {
            val newlyEditedTask = view.findViewById<EditText>(R.id.saver_task).text.toString()
            Log.d("Meme", "before returning to FragmentOne $newlyEditedTask")
            var listViewModel = ListViewModel()
            listViewModel.tasks[viewModel.positionClicked] = newlyEditedTask
            //TODO: Figure out what's going on with below
            val action =
                FragmentTwoDirections.actionFragmentOneToFragmentTwo(newlyEditedTask, "")

            findNavController().navigate(action)
        }

    }
}

