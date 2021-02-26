package com.andorid.mytodolist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add.view.*
import kotlinx.android.synthetic.main.recyler_view_item.view.*
import java.lang.reflect.Array.get

class TasksAdaptor(var Tasks: List<Task>):RecyclerView.Adapter<TasksAdaptor.ViewHolder>(){
    class ViewHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        var title: TextView = itemview.title_ecyler
        var checkbox: CheckBox = itemview.complectCheckbox
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var Task = Tasks.get(position)
        holder.title.setText(Task.titleTask)
        holder.checkbox.isChecked = Task.IsCompletedTask ?: false


        if (setoneItemClick != null) {
            holder.itemView.setOnClickListener {
                setoneItemClick?.onItemSlected(Task, position = position)
            }
        }

        if (setlongItemClick != null) {
            holder.itemView.setOnLongClickListener(object :View.OnLongClickListener{
                override fun onLongClick(v: View?): Boolean {
                    setlongItemClick?.onItemSlected(Task, position)
                    return false
                }

            })

        }
    }

    var setlongItemClick:setOnItamClickinterface?=null
    var setoneItemClick :setOnItamClickinterface?=null
    interface setOnItamClickinterface{
        fun onItemSlected(Tasks:Task, position: Int)
    }
    fun gettaskbypositon(position: Int):Task{
        return Tasks.get(position)
    }

    fun ChangData(task: List<Task>) {
        this.Tasks= task
        notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return Tasks.size
    }

}