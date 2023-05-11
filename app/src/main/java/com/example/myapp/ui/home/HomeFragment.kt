package com.example.myapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapp.R
import com.example.myapp.adapter.TaskAdapter
import com.example.myapp.databinding.FragmentHomeBinding
import com.example.myapp.task.TaskFragment
import com.example.myapp.task.model.Task

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter=TaskAdapter()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        binding.fab.setOnClickListener{
            setFragmentResultListener(TaskFragment.TASK_REQUEST){
                requestKey, bundle ->
                val result= bundle.getSerializable(TaskFragment.TASK_KEY) as Task
                adapter.addTask(result)
            }
            findNavController().navigate(R.id.taskFragment)
        }
    }
}