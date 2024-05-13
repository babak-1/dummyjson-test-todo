package com.babak.retrofitapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.babak.retrofitapi.databinding.ItemTodoBinding

class TodoAdapter :RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    inner class TodoViewHolder(val itemTodoBinding: ItemTodoBinding):RecyclerView.ViewHolder(itemTodoBinding.root)
    private val todoList = arrayListOf<TodoModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = ItemTodoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TodoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.itemTodoBinding.todoItemText.text=todo.todo
    }

    fun updateList(newList:ArrayList<TodoModel>){
        todoList.clear()
        todoList.addAll(newList)
        notifyDataSetChanged()
    }


}