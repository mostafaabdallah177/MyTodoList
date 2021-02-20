package com.andorid.mytodolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        add_btn.setOnClickListener {
            openAddActitvtiy()
        }
    }

    private fun openAddActitvtiy() {
       val intent= Intent(this,Add_Actitvity::class.java)
        startActivity(intent)
    }
}