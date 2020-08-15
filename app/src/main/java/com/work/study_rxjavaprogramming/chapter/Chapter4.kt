package com.work.study_rxjavaprogramming.chapter

import android.annotation.SuppressLint
import android.os.Bundle
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R

class Chapter4 : BaseActivity(R.layout.activity_chapter4) {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 생성 연산자.
        // 데이터 흐름을 만드는 역할
        // 간단하게 Observable, single, maybe 객체 등을 만드는 거라고 생각하면 된다.

        // interval()
        // 일정 시간 간격으로 데이터 흐름을 생성.

//        CommonUtils.exampleStart()
//        Observable.interval(1000L, TimeUnit.MILLISECONDS).map { data -> (data + 1) * 100 }.take(5)
//            .subscribe {
//                Log.d("결과", it.toString())
//            }
//        CommonUtils.sleep(1000)

        // 초기 지연시간을 넣은 경우.
//        CommonUtils.exampleStart()
//        Observable.interval(0L,1000L, TimeUnit.MILLISECONDS).map { data -> (data + 100)}.take(5)
//            .subscribe {
//                Log.d("결과", it.toString())
//            }
//        CommonUtils.sleep(1000)

        // Timer()
        // interval() 유사하지만 한 번만 실행하는 함수.
        // 일정 시간이 지난 후 한개의 데이터를 발행하고 onComplete() 이벤트를 발생한다

        // 요거는 100 만 출력.
//        CommonUtils.exampleStart()
//        Observable.timer(1000L, TimeUnit.MILLISECONDS).map { data -> (data + 1) * 100 }.take(5)
//            .subscribe {
//                Log.d("결과", it.toString())
//            }
//        CommonUtils.sleep(1000)

        // range()
        // 주어진 값 n 부터 m 개의 Integer 객체를 발행.
        // 위 두개와 다르게 이건 Long 이 아닌 Integer!
        // 또 위 두개와 다른게 스케줄러에서 실행되지 않음. => 현재의 스레드에서 실행.
        // for , while 문 대처.

//        Observable.range(1, 10).filter { it % 2 == 0 }.subscribe { Log.d("결과", it.toString()) }

        // intervalRange()
        // interval + range
        // 일정한 시간 간격으로 값을 출력하지만 시작숫자로부터 몇개만큼 값만 생성하고 onComplete 이벤트 발생
        // interval 함수처럼 무한히 데이터 흐름을 발행하지 않습니다.
        // return type  => Long

//        Observable.intervalRange(1, 10, 100L,1000L, TimeUnit.MILLISECONDS)
//            .subscribe { Log.d("결과", it.toString()) }

        // map 해서 take 했던것보다 좀더 직관적이다는데 난 머 그냥 그저그럼..

        // defer()
        // time() 과 비슷하지만 데이터 흐름 생성을 구독자가 subscribe 함수를 호출할 때까지 미룰수 있음.
        // 호출하면 새로운 Observable 이 생성.

        // repeat()
        // 반복
//        Observable.fromArray("1", "2", "3").repeat(3).subscribe(
//            { Log.d("결과", it) }, {},
//            { Log.d("결과", "complete") }
//        )

    }
}