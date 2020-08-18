package com.work.study_rxjavaprogramming.util

import android.util.Log
import java.io.IOException
import java.net.InetAddress

object CommonUtils {
    const val GITHUB_ROOT =
        "https://raw.githubusercontent.com/yudong80/reactivejava/master/"
    const val API_KEY = "5712cae3137a8f6bcbebe4fb35dfb434"

    //	"e7681f2ac93cbdf1bc3952e30ab80533";
    //	"fe6edeb30e2b9ee7848e4ded0491d8d1";
    const val ERROR_CODE = "-500"
    var startTime: Long = 0
    fun exampleStart() {
        startTime = System.currentTimeMillis()
    }

    fun exampleComplete() {
        println("-----------------------")
    }

    fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    private const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    fun numberToAlphabet(x: Long): String {
        return ALPHABET[x.toInt() % ALPHABET.length].toString()
    }

    val isNetworkAvailable: Boolean
        get() {
            try {
                return InetAddress.getByName("www.google.com").isReachable(1000)
            } catch (e: IOException) {
                Log.v("", "Network is not available")
            }
            return false
        }

    fun toInt(`val`: String): Int {
        return `val`.toInt()
    }

}