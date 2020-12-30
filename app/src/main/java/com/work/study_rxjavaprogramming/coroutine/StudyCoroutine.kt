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

class StudyCoroutine : BaseActivity<ActivityCoroutineBinding>(R.layout.activity_coroutine) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        GlobalScope.launch(Dispatchers.IO) {

            val editTextFlow = binding.etText.textChangeToFlow()

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
}