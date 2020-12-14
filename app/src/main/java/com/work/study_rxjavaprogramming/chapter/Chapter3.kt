package com.work.study_rxjavaprogramming.chapter

import android.annotation.SuppressLint
import android.os.Bundle
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R
import com.work.study_rxjavaprogramming.databinding.ActivityChapter3Binding
import io.reactivex.Observable
import io.reactivex.functions.Function

class Chapter3 : BaseActivity<ActivityChapter3Binding>(R.layout.activity_chapter3) {

    // Observable 에서 발행한 데이터를 가공, 변환, 조합하는 다양한 연산자 함수에 대한 꼼지락.


    // 다시한번 상기하자
    // 리액티브 프로그래밍 => 함수형 프로그래밍 도구를 활용한 비동기 프로그래밍.
    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // map()
        // 입력값을 어떤 함수에 넣어서 원하는 값으로 변환하는 함수.


//        Observable.fromArray(arrayOf("park", "duk", "sung"))
//            .map {
//                it.map { string -> string.length }
//            }.subscribe { data ->
//                Log.d("결과", data.toString())
//            }
//        Observable.fromArray(arrayOf("park", "duk", "sung"))
//            .map(::toInt).subscribe { data ->
//                Log.d("결과", data.toString())
//            }

        // flatMap()
        // map 은 원하는 입력 값을 어떤 함수에 넣어서 변환할 수 있는 일대일 함수라면
        // flatMap 은 일대다 혹은 일대일
        //  동일한 로직이라면 둘다 한번에 돌려버릴수 있을듯.
//        Observable.fromArray(arrayOf("park", "duk", "sung")).map(::toInt)
//            .flatMap { Observable.just(it, it) }
//            .subscribe { data -> data.forEach { Log.d("결과", it.toString()) } }

        // just 에 들어갈 숫자에 대한 구구단.
//        Observable.just(2).flatMap { input ->
//            Observable.range(1, 9).map { input * it }
//        }.subscribe { data -> Log.d("결과", data.toString()) }


        // 구구단 전체.
//        Observable.range(1, 9).flatMap { input ->
//            Observable.range(1, 9).map { input * it }
//        }.subscribe { data -> Log.d("결과", data.toString()) }


        // 익명함수 만들어 이렇게 하는것도 좋은방법 => gugudan 이라는 익명함수의 로직만 바꿔주면 되고 훨씬 가독성있다고 생각이 든다.
//        Observable.range(1, 9).flatMap(gugudan).subscribe { data -> Log.d("결과", data.toString()) }

        // filter()
        // Observable 에서 내가 원하는것만 걸러내는 역할
        // 머 여러가지 있는거 같은데 그중 필요하다 싶은거 가져다 쓰면될듯.

//        Observable.just(10, 11, 13, 16, 25, 100).filter { it % 2 == 0 }
//            .subscribe { data -> Log.d("결과", data.toString()) }

        // reduce()
        // 발행한 데이터를 모두 사용하여 어떤 최종 결과 데이터를 합성할 때 활용.
        // 상황에 따라 데이터를 취합하여 어떤 결과를 만들어 낼 때는 reduce 계열의 함수를 사용.

        // 근데 사실 이게 필요도 할까...? 모르겟네..
//        Observable.fromArray(arrayOf(1, 3, 5))
//            .reduce { t1: Array<Int>, t2: Array<Int> -> t2 + t1 }
//            .subscribe(::print)

    }

    private fun toInt(array: Array<String>): List<Int> =
        array.map { it.length }

    private val gugudan =
        Function<Int, Observable<Int>> { num ->
            Observable.range(1, 9)
                .map<Int> { row: Int -> num * row }
        }

//    var source =
//        Observable.just(10)
//            .flatMap<Int, String>(
//                { gugu: Int? ->
//                    Observable.range(
//                        1,
//                        9
//                    )
//                }
//            ) { gugu: Int, i: Int -> gugu.toString() + " * " + i + " = " + gugu * i }
}