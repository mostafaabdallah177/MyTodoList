package com.andorid.mytodolist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_add.*

class Add_Actitvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        changeerror()
        save_btn.setOnClickListener {
            addtask()
        }
    }
// fun to make when the edit text is Empty make it read >>
// reomve This red when you back to write in the editText
    private fun changeerror() {
        titlelayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                titlelayout.error = null

            }
        })
        desclayout.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                desclayout.error = null

            }
        })

    }


    private fun addtask() {
        if (!Vailddata()) return
        // code to add the task into databdase
            var task = Task(
                titleTask = titlelayout.editText?.text.toString(),
                DescripitonTask = desclayout.editText?.text.toString(),
                IsCompletedTask = isComplet.isChecked)
        //database creatction
                TaskDatabase.getInstance(applicationContext)
                    .tasksDao()
                    .addTask(task)

         val Alrt = AlertDialog.Builder(this)
             .setMessage("Add Done")
             .setPositiveButton("ok",DialogInterface.OnClickListener{
                 dialog, which ->
                 dialog.dismiss()
                 finish()
             })

         Alrt.show()
    }

// to know the data is vaild or not vaild
    private fun Vailddata(): Boolean {
        var isVaild = true;
        if (titlelayout.editText?.text.toString().isBlank()) {
            isVaild = false
            //make the edittext red wehen he is Empty
            titlelayout.error = "Plz Enter Your Title"
        }
        if (desclayout.editText?.text.toString().isBlank()) {
            isVaild = false
            //make the edittext red wehen he is Empty
            desclayout.error = "Plz Enter Your Title"
        }
        return isVaild
    }
}