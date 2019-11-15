package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_input.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOk.setOnClickListener {
            val okIntent = Intent(this, SecondActivity::class.java)
            val data = editText.text.toString()
            okIntent.putExtra("question", data)
            startActivityForResult(okIntent, 10)
        }
        editText.setHint(R.string.question_hint)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 10) {
            if (resultCode == Activity.RESULT_OK) {
                var result = data?.getStringExtra("result")
                textViewResult.text = result
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val exitDialog = ExitDialog()
        exitDialog.show(this.supportFragmentManager, "dialog")
        return super.onOptionsItemSelected(item)
    }
}
