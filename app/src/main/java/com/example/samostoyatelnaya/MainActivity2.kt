package com.example.samostoyatelnaya

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    var counter = 0
    var pref: SharedPreferences? = null
    lateinit var res:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        res = findViewById(R.id.text)
        pref = getSharedPreferences("TABLE", MODE_PRIVATE)
        counter = pref?.getInt("counter", 0)!!
        res.text = counter.toString()
    }

    fun plus(view: View) {
        counter++
        res.text = counter.toString()
    }
    fun saveData(resultat: Int){
        val editor=pref?.edit()
        editor?.putInt("counter", resultat)
        editor?.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        saveData(counter)
    }
    fun minus(view: View) {
        counter = counter - 1
        res.text = counter.toString()
    }
    fun save(view: View) {
        saveData(counter)
    }
}