package com.example.samostoyatelnaya

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    var counter = 0
    var pref : SharedPreferences?  = null
    lateinit var tvResult:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        pref = getSharedPreferences("table", Context.MODE_PRIVATE)
        counter = pref?.getInt("counter", 0)!!
        tvResult.text = counter.toString()
    }

    fun plusone(view: View) {
        counter++
        tvResult.text = counter.toString()
    }
    fun saveData(res:Int){
        val editor = pref?.edit()
        editor?.putInt("counter", res)
        editor?.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData(counter)
    }

}