package com.work.study_rxjavaprogramming.coroutine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudyCoroutineViewModel : ViewModel() {


    val editText = MutableLiveData<String>()


    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text

    fun start() {
        _text.value = editText.value
    }

}