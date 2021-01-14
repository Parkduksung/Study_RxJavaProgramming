package com.work.study_rxjavaprogramming.coroutine

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R
import com.work.study_rxjavaprogramming.databinding.ActivityCoroutineBinding

class StudyCoroutine : BaseActivity<ActivityCoroutineBinding>(R.layout.activity_coroutine) {

    private val studyCoroutineViewModel: StudyCoroutineViewModel by lazy {
        ViewModelProvider(this).get(
            StudyCoroutineViewModel::class.java
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.run {
            viewModel = studyCoroutineViewModel
            lifecycleOwner = this@StudyCoroutine
        }

        binding.btnStart.setOnClickListener {
            studyCoroutineViewModel.start()
        }

    }

}