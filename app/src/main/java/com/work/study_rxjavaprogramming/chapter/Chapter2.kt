package com.work.study_rxjavaprogramming.chapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R
import io.reactivex.Observable

class Chapter2 : BaseActivity(R.layout.activity_chapter2) {

    //Observable 에 대한 챕터

    // Observed 라는 단어가 관찰을 통해 얻은 결과를 의미한다면 , Observable 은 현재는 관찰되지 않았지만
    // 이론을 통해서 앞으로 관찰할 가능성을 의미한다.

    // onClick 같이 클릭했을때 onClick() 이라는 메서다를 호출해 원하는 처리를 하는게 대표적인 Observable 패턴.

    // Observable 의 3가지 알림
    // onNext : Observable 이 데이터의 발행을 알린다.
    // onComplete : 모든 데이터의 발행을 완료했음을 알림.
    // onError : Observable 에서 어떤 이유로 에러가 발생했음을 알리는 것.


    // 1)
    // just() 함수
    // 안을 까보면 제네릭으로 데이터 형태를 받아 모두 같은 형태의 데이터를 입력받고 그에 Array 를 반환한다.

    //
    //public static <T> Observable<T> just(T item1, T item2, T item3, T item4, T item5) {
    //        ObjectHelper.requireNonNull(item1, "The first item is null");
    //        ObjectHelper.requireNonNull(item2, "The second item is null");
    //        ObjectHelper.requireNonNull(item3, "The third item is null");
    //        ObjectHelper.requireNonNull(item4, "The fourth item is null");
    //        ObjectHelper.requireNonNull(item5, "The fifth item is null");
    //
    //        return fromArray(item1, item2, item3, item4, item5);
    //    }
    //

    // 2)
    // subscribe() 함수
    // RxJava 는 내가 동작시키기 원하는 것을 사전에 정의해두고 실행 시점을 조절할 수 있는데 이때 subscribe() 함수 사용

    // 3) Disposable 인터페이스
    // void dispose() ,  boolean isDisposed() 두개밖에 함수가 없다.
    // dispose()
    // Observable 에게 더이상 데이터를 발행하지 않도록 구독 해지하는 함수.
    // Observable 이 onComplete 알림을 보냈을 때 자동으로 dispose() 호출해 Observable 과 구독자 관계를 끊는다.
    // isDisposed()
    // Observable 구독을 해지했는지 확인하는 함수.
    // 정상적으로 구독이 해지됬으면 true 그렇지 않으면 false

    @SuppressLint("CheckResult")  // 이거 왜 되는거임??
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val observable: Observable<String> = Observable.just("RED", "GREEN", "YELLOW")

        observable.subscribe(
            { Log.d("결과", it) },
            { Log.d("결과", it.toString()) },
            { Log.d("결과", "onComplete") },
            { Log.d("결과", "dispose o") }
        )

    }
}