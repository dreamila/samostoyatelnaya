package com.example.samostoyatelnaya

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    var counter = 0
    var pref : SharedPreferences? = null
    lateinit var res:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        pref = getSharedPreferences("table", Context.MODE_PRIVATE)
        counter = pref?.getInt("counter", 0)!!
        res.text = counter.toString()
    }

    fun plus(view: View) {
        counter++
        res.text = counter.toString()
    }
    fun minus(view: View) {
        counter = counter - 1
        res.text = counter.toString()
    }
    fun saveData(res: Int){
        val editor = pref?.edit()
        editor?.putInt("counter", res)
        editor?.apply()
    }
    fun save(view: View) {
        saveData(counter)
    }
}