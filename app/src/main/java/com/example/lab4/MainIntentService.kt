package com.example.lab4

import android.app.IntentService
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager


class MainIntentService : IntentService("PrimesService") {
    override fun onHandleIntent(intent: Intent?) {
        val num = intent!!.getIntExtra("number", 0)
        val primeNumbers = getPrimaryNumbers(num)
        val count = primeNumbers.size
        val primesString = primeNumbers.joinToString(", ")
        sendPrimeNumbersToUser(count, primesString)
    }

    private fun getPrimaryNumbers(num: Int): List<Int> {
        val primeNumbers = ArrayList<Int>()
        if (num >= 2) {
            primeNumbers.add(2)
        }
        else {
            for (j in 3..num step 2) {
                if (isPrime(j))
                    primeNumbers.add(j)
            }
        }
        return primeNumbers
    }

    fun isPrime(n: Int): Boolean {
        var i = 3
        while (i * i < n) {
            if (n % i == 0)
                return false
            i += 2
        }
        return true
    }

    private fun sendPrimeNumbersToUser(total: Int, allNumbers: String) {
        val intent = Intent("MainActivity")
        intent.putExtra("prime_numbers", allNumbers)
        intent.putExtra("amount", total)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }
}