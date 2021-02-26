package com.andorid.mytodolist
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adaptor: TasksAdaptor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_btn.setOnClickListener {
            openAddActitvtiy()
        }
        creatRecylerView()
        oneClickLisner()
    }
     fun oneClickLisner() {
         adaptor.setoneItemClick =
             object : TasksAdaptor.setOnItamClickinterface {
                 override fun onItemSlected(Tasks: Task, position: Int) {

                     val bundle = Bundle()
                     bundle.putSerializable("Key", Tasks)
                     val dialog = Dialog_Fragment()
                     dialog.setArguments(bundle)
                     dialog.show(supportFragmentManager, "Task")
                 }
             }
    }
    private fun creatRecylerView() {
        adaptor= TasksAdaptor(listOf())
        recylerview_Task.adapter=adaptor

        var SimpleCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        )

        {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val Position = viewHolder.adapterPosition
                val task =   adaptor.gettaskbypositon(position = Position)
              TaskDatabase.getInstance(applicationContext)
                        .tasksDao()
                        .DeleteTask(task)
                        reload()

            }
        }
        var   itemTouchHelper: ItemTouchHelper= ItemTouchHelper(SimpleCallback)
        itemTouchHelper.attachToRecyclerView(recylerview_Task)


    }
        fun reload(){
    val tasks=   TaskDatabase.getInstance(applicationContext)
            .tasksDao()
            .SelectAllTasks()
    adaptor.ChangData(tasks)
}
    override fun onStart() {
        super.onStart()
         val tasks=   TaskDatabase.getInstance(applicationContext)
                .tasksDao()
                .SelectAllTasks()
        adaptor.ChangData(tasks)
    }
    private fun openAddActitvtiy() {
       val intent= Intent(this, Add_Actitvity::class.java)
        startActivity(intent)
    }
}
