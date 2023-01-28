package com.example.samostoyatelnaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import android.content.Intent
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var pass:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email=findViewById(R.id.email)
        pass=findViewById(R.id.pass)
    }

    fun next(view: View) {
        if(email.text.toString().isNotEmpty()&&pass.text.toString().isNotEmpty())
        {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        else
        {
            Toast.makeText(this, "Заполните тексовые поля", Toast.LENGTH_SHORT).show()
        }
    }
}