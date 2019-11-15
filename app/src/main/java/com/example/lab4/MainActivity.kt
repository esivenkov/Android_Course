package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LocalBroadcastManager.getInstance(this).registerReceiver(messageReceiver, IntentFilter("MainActivity"))

        submitButton.setOnClickListener {
            val number = Integer.valueOf(inputValue.getText().toString())
            val intent = Intent(applicationContext, MainIntentService::class.java)
            intent.putExtra("number", number)
            startService(intent)
            submitButton.setEnabled(false)
        }
    }

    var messageReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val numbers = intent.getStringExtra("prime_numbers")
            val numbersAmount = intent.getIntExtra("amount", 0)
            primeNumbersTextView.setText(numbers)
            TextViewMain.setText(Integer.toString(numbersAmount))
            submitButton.setEnabled(true)
        }
    }
}
