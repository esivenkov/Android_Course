package com.example.lab2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClick_toSecondActivity(view: View) {
        val okIntent = Intent(this, SecondActivity::class.java)
        val data = editTextQuestion.text.toString()
        okIntent.putExtra("question", data)
        startActivityForResult(okIntent, 10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                var result = data?.getStringExtra("result")
                textViewResult.text = result
            }
        }
    }
}
