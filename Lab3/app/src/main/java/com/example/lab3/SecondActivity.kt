package com.example.lab3

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.fragment_input.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        textViewQuestion.text = intent.getStringExtra("question")
        buttonOk.setOnClickListener {
            var returnIntent = Intent();
            var result = editText.text.toString()
            returnIntent.putExtra("result", result)
            setResult(Activity.RESULT_OK, returnIntent)
            finish()

        }

        editText.setHint(R.string.answer_hint)
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

