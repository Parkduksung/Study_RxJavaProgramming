package com.work.study_rxjavaprogramming.chapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_chapter6.*


class Chapter6 : BaseActivity(R.layout.activity_chapter6) {

    //RxAndroid 구성요소
    // Observable : 비지니스 로직을 이용해 데이터를 발행.
    // 구독자 : Observable 에서 발행한 데이터를 구독합니다.
    // 스케줄러 : 스케줄러를 통해서 Observable, 구독자가 어느 스레드에서 실행될지 결정할 수 있습니다.

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 인자에 제공된 값을 방출 해서 그걸 길이로 다 바꿧고 그걸 출력해보았다.
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .map { it.length }
            .subscribe(::println)


        // et 에서 변화되면 이 변화를 감지해서 tv 의 text 로 값을 주는방식을 생각해서 짜봤음.
        et_text1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Observable.just(s).subscribe(tv_text1::setText)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })
    }


}