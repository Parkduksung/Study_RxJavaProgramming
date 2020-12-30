package com.work.study_rxjavaprogramming.coroutine

import android.os.Bundle
import android.util.Log
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R
import com.work.study_rxjavaprogramming.databinding.ActivityCoroutineBinding
import com.work.study_rxjavaprogramming.ext.textChangeToFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.coroutines.CoroutineContext

class StudyCoroutine : BaseActivity<ActivityCoroutineBinding>(R.layout.activity_coroutine) {

    private val myCoroutineJob = Job()

    private val jobOne = GlobalScope.launch {
        for(i in 0..10){
            Log.d("결과", i.toString())
            delay(1000)
        }
    }

    private val jobTwo = GlobalScope.async {
            var sum = 0
            for (i in 0..10) {
                sum += i
                delay(500)
            }
            Log.d("결과", sum.toString())
            sum
    }

    //순서 = c - a - b - d
    private fun jobThree() {
        runBlocking { // this: CoroutineScope
            launch {
                delay(200L)
                println("a")
            }

            coroutineScope { // Creates a coroutine scope
                launch {
                    delay(500L)
                    println("b")
                }

                delay(100L)
                println("c") // This line will be printed before the nested launch
            }

            println("d") // This line is not printed until the nested launch completes
        }
    }

    private val myCoroutineContext: CoroutineContext
        get() = Dispatchers.IO + myCoroutineJob + jobOne + jobTwo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        GlobalScope.launch(myCoroutineContext) {

            jobThree()

            val editTextFlow =
                binding.etText.textChangeToFlow()

            editTextFlow
                .debounce(1500)
                .filter {
                    it?.length!! > 0
                }
                .onEach {
                    Log.d("결과", it.toString())
                }
                .launchIn(this)
        }

    }

    override fun onDestroy() {
        myCoroutineContext.cancel()
        super.onDestroy()
    }
}