package com.example.myapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapp.databinding.ItemTaskBinding
import com.example.myapp.task.model.Task

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    private val data = arrayListOf<Task>()


    fun addTask(task: Task){
        data.add(0, task)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
       return TaskViewHolder(ItemTaskBinding.inflate(
           LayoutInflater.from(parent.context)
           ,parent,
           false)
       )
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data.get(position))
    }
    class  TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root){
        fun bind(task: Task) {

            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc

        }

    }
}