package com.work.study_rxjavaprogramming.chapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import com.work.study_rxjavaprogramming.BaseActivity
import com.work.study_rxjavaprogramming.R
import com.work.study_rxjavaprogramming.util.Shape
import com.work.study_rxjavaprogramming.util.Shape.GREEN
import com.work.study_rxjavaprogramming.util.Shape.RED
import com.work.study_rxjavaprogramming.util.Shape.SKY
import com.work.study_rxjavaprogramming.util.Shape.YELLOW
import com.work.study_rxjavaprogramming.util.Shape.rectangle
import io.reactivex.Observable
import io.reactivex.Single


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

        // 변환 연산자
        // 데이터 흐름을 원하는 대로 변형할 수 있는 변환 연산자~
        // 기본이 되는 함수와 비교하여 어떻게 다른지 그 차이점을 기억하는것이 좋다.

        // concatMap()
        // flatMap() 과 유사.
        // flatMap 은 먼저 들어온 데이터 처리도중 새로운 데이터가 들어오면 나중에 들어온 데이터의 처리 결과가 먼저 처리될수 있는 인터리빙이 발생가능할 수 있다.
        // concatMap 은 인터리빙이 발생하지 않고 먼저 들어온 데이터 순서대로 처리해서 결과를 낼 수 있도록 보장.
//        val balls = arrayOf("1", "3", "5")
//        CommonUtils.exampleStart()

//        Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::toInt).map { idx -> balls[idx] }
//            .take(balls.size.toLong()).concatMap { ball ->
//                Observable.interval(200L, TimeUnit.MILLISECONDS).map { notUsed -> "$ball<>" }
//                    .take(2)
//            }.subscribe { data -> Log.d("결과", data) }
//
//        CommonUtils.sleep(2000)

        //결과 113355

//        CommonUtils.exampleStart()
//
//        Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::toInt).map { idx -> balls[idx] }
//            .take(balls.size.toLong()).flatMap { ball ->
//                Observable.interval(200L, TimeUnit.MILLISECONDS).map { notUsed -> "$ball<>" }
//                    .take(2)
//            }.subscribe { data -> Log.d("결과", data) }
//
//        CommonUtils.sleep(2000)

        //결과 135135

        // switchMap()
        // concatMap() 함수가 인터리빙이 발생할 수 있는 상황에서 동작의 순서를 보장한다면
        // switchMap() 함수는 순서를 보장하기 위해 기존에 진행 중이던 작업을 바로 중단함.
        // 그리고 여러개 값 발행될때 마지막 들어온 값만 처리하고 싶을때 사용.
        // 느낌이 중간엔 끊기더라도 마지막 데이터 처리는 보장한다는 의미.

//        CommonUtils.exampleStart()
//
//        Observable.interval(100L, TimeUnit.MILLISECONDS).map(Long::toInt).map { idx -> balls[idx] }
//            .take(balls.size.toLong()).doOnNext { Log.d("중간결과", it) }.switchMap { ball ->
//                Observable.interval(200L, TimeUnit.MILLISECONDS).map { notUsed -> "$ball<>" }
//                    .take(2)
//            }.subscribe { data -> Log.d("결과", data) }
//
//        CommonUtils.sleep(2000)

        // groupBy()
        // 어떤 기준으로 단일 Observable 을 여러 개로 이루어진 Observable 그룹으로 만드는 것 .

//        val objs = arrayOf<String>(
//            PUPPLE,
//            SKY,
//            triangle(YELLOW),
//            YELLOW,
//            triangle(PUPPLE),
//            triangle(SKY)
//        )
//        val source =
//            Observable.fromArray(*objs)
//                .groupBy(Shape::getShape)
//
//        source.subscribe { obj: GroupedObservable<String, String> ->
//            obj.subscribe { `val`: String ->
//                println(
//                    "GROUP:" + obj.key + "\t Value:" + `val`
//                )
//            }
//        }

        //filter 적용시.
//        val source: Observable<GroupedObservable<String, String>> =
//            Observable.fromArray(*objs)
//                .groupBy(Shape::getShape)
//
//        source.subscribe { obj: GroupedObservable<String, String> ->
//            obj.filter { `val`: String? -> obj.key == Shape.BALL }
//                .subscribe { `val`: String ->
//                    println(
//                        "GROUP:" + obj.key + "\t Value:" + `val`
//                    )
//                }
//        }

        // scan()
        // reduce() 와 비슷. 근데 reduce 는 모든 데이터 입력 후 그것들 종합하여 마지막 1개만 구독한다면
        // scan() 은 reduce + 중간결과라 생각하면 된다.

//        Observable.fromArray("1", "3", "5").scan { t1: String, t2: String -> "$t2($t1)" }
//            .subscribe { data -> Log.d("결과", data) }


        // 결합연산자
        // 다수의 Observable 을 하나로 합하는 방법을 제공.
//        val shapes = arrayOf(BALL, PENTAGON, STAR)
//        val coloredTriangles =
//            arrayOf(triangle(YELLOW), triangle(PUPPLE), triangle(SKY))
//
//        val source =
//            Observable.zip(
//                Observable.fromArray(*shapes)
//                    .map<String>(Shape::getSuffix),
//                Observable.fromArray(*coloredTriangles)
//                    .map<String>(Shape::getColor),
//                BiFunction<String, String, String> { suffix: String, color: String -> color + suffix }
//            )
//
//        source.subscribe { data ->
//            Log.d("결과", data)
//        }

//
//        val source = Observable.zip(
//            Observable.just(100, 200, 300),
//            Observable.just(10, 20, 30),
//            Observable.just(1, 2, 3),
//            Function3 { a: Int, b: Int, c: Int -> a + b + c }
//        )
//
//        source.subscribe { data ->
//            Log.d("결과", data.toString())
//        }
//        val source =
//            Observable.zip(
//                Observable.just(100, 200, 300),
//                Observable.just(10, 20, 30),
//                BiFunction<Int, Int, Int> { a: Int, b: Int -> a + b }
//            )
//                .zipWith(
//                    Observable.just(1, 2, 3),
//                    BiFunction<Int, Int, Int> { ab: Int, c: Int -> ab + c }
//                )
//        source.subscribe { data ->
//            Log.d("결과", data.toString())
//        }

        // combineLatest()
        // zip 의 zipper 랑 동일한 역할.
        // 2개 이상의 Observable 을 기반으로 Observable 각각의 값이 변경되었을 때 갱신해주는 함수.
//
//        val data1 =
//            arrayOf<String>(PUPPLE, ORANGE, SKY, YELLOW) //6, 7, 4, 2
//
//        val data2 = arrayOf<String>(DIAMOND, STAR, PENTAGON)
//
//        val source =
//            Observable.combineLatest(
//                Observable.fromArray(*data1)
//                    .zipWith( //zipWith()로 깔끔하게 코드 정리
//                        Observable.interval(100L, java.util.concurrent.TimeUnit.MILLISECONDS),
//                        BiFunction { shape: String, notUsed: Long ->
//                            Shape.getColor(
//                                shape
//                            )
//                        }
//                    ),
//                Observable.fromArray(*data2)
//                    .zipWith(
//                        Observable.interval(150L, 200L, java.util.concurrent.TimeUnit.MILLISECONDS),
//                        BiFunction { shape: String, notUsed: Long ->
//                            Shape.getSuffix(
//                                shape
//                            )
//                        }
//                    ),
//                BiFunction<String, String, String> { v1: String, v2: String -> v1 + v2 }
//            )
//        source.subscribe { data ->
//            Log.d("결과", data.toString())
//        }
//
//        sleep(1000)
//        exampleComplete()

//        val source1 =
//            Observable.interval(100L, java.util.concurrent.TimeUnit.MILLISECONDS)
//                .map<String> { obj: Long -> CommonUtils.numberToAlphabet(obj) }
//        val source2 =
//            Observable.interval(200L, java.util.concurrent.TimeUnit.MILLISECONDS)
//        val combiner =
//            BiFunction { val1: String, val2: Long -> val1 + val2 }
//
//        val source =
//            Observable.combineLatest(
//                source1,
//                source2,
//                combiner
//            )
//        source.subscribe { data ->
//            Log.d("결과", data.toString())
//        }
//
//        sleep(500)
//        exampleComplete()

        // merge()
        // 입력 Observable 의 순서와 모든 Observable 이 데이터를 발행하는지 등에 관여하지 않고 어느 것이든 업스트림에서
        // 먼저 입력되는 데이터를 그대로 발행한다.
//
//        val array1 = arrayOf("1", "3")
//        val array2 = arrayOf("2", "4", "6")
//
//        val source1 = Observable.interval(0L, 100L, java.util.concurrent.TimeUnit.MILLISECONDS)
//            .map(Long::toInt).map { idx -> array1[idx] }.take(array1.size.toLong())
//        val source2 = Observable.interval(50L, java.util.concurrent.TimeUnit.MILLISECONDS)
//            .map(Long::toInt).map { idx -> array2[idx] }.take(array2.size.toLong())
//
//
//        Observable.merge(source1, source2).subscribe { data -> Log.d("결과", data) }
//        CommonUtils.sleep(1000)

        //각자 다른 스페드에서 발행하는걸 잊지말자!

        // concat()
        // 2개 이상의 Observable 을 이어주는 함수
        // 첫번째가 onComplete 되면 그다음 구독

//        val action = Action {
//            Log.d("결과", "끝")
//        }
//
//        val array1 = arrayOf("1", "3", "5")
//        val array2 = arrayOf("2", "4", "6")
//
//        val source1 = Observable.fromArray(*array1).doOnComplete(action)
//        val source2 = Observable.interval(50L, java.util.concurrent.TimeUnit.MILLISECONDS)
//            .map(Long::toInt).map { idx -> array2[idx] }.take(array2.size.toLong())
//            .doOnComplete(action)
//
//
//        Observable.concat(source1, source2).doOnComplete(action).subscribe {
//            Log.d(
//                "결과",
//                it as String
//            )
//        }
//        CommonUtils.sleep(1000)


        // 조건연산자
        // Observable 의 흐름을 제어하는 역할을 한다.

        // amb()
        // ambiguous(모호한) 이라는 영어 단어의 줄임말
        // 가장 먼저 Observable 을 발행한것만 데이터 발생하고 나머지 모두 무시 .

        // 가장 먼저 데이터를 발행한 거의 다음이 3,5 라고 한다면 이 사이에 2, 4 라는게 있다 하더라도 무시.
        // 1   3    5
        //  2 4  6
        // 발행은 1, 3, 5 만.


//        val data1 = arrayOf(RED, GREEN, BLUE)
//        val data2 = arrayOf(rectangle(YELLOW), rectangle(SKY))
//
//        val sources =
//            listOf(
//                Observable.fromArray(*data1)
//                    .doOnComplete { Log.d("결과", "Observable #1 : onComplete()") },
//                Observable.fromArray(*data2)
//                    .delay(100L, java.util.concurrent.TimeUnit.MILLISECONDS)
//                    .doOnComplete { Log.d("결과", "Observable #2 : onComplete()") }
//            )
//
//        Observable.amb(sources)
//            .doOnComplete { Log.d("결과", "Result : onComplete()") }
//            .subscribe {
//                Log.d("결과", it)
//            }
//        sleep(1000)
//        exampleComplete()

        // takeUntil()
        // take 함수에 조건을 설정하는 것.
//
//        val data =
//            arrayOf(RED, YELLOW, GREEN, SKY, BLUE, PUPPLE)
//
//        val source: Observable<String> =
//            Observable.fromArray(*data)
//                .zipWith(
//                    Observable.interval(
//                        100L,
//                        java.util.concurrent.TimeUnit.MILLISECONDS
//                    ),
//                    BiFunction<String, Long, String> { `val`: String, _ -> `val` }
//                )
//                .takeUntil(
//                    Observable.timer(
//                        500L,
//                        java.util.concurrent.TimeUnit.MILLISECONDS
//                    )
//                )
//
//        source.subscribe {
//            Log.d("결과", it)
//        }
//        sleep(1000)
//        exampleComplete()

        // skipUntil()
//        val data =
//            arrayOf(RED, YELLOW, GREEN, SKY, BLUE, PUPPLE)
//
//        val source: Observable<String> =
//            Observable.fromArray(*data)
//                .zipWith(
//                    Observable.interval(
//                        100L,
//                        java.util.concurrent.TimeUnit.MILLISECONDS
//                    ),
//                    BiFunction<String, Long, String> { `val`: String, _ -> `val` }
//                )
//                .skipUntil(
//                    Observable.timer(
//                        500L,
//                        java.util.concurrent.TimeUnit.MILLISECONDS
//                    )
//                )
//
//        source.subscribe {
//            Log.d("결과", it)
//        }
//        sleep(1000)
//        exampleComplete()
//

        // all()
        // 조건 맞으면 true 아니면 false 리턴

//        val data =
//            arrayOf("1", "2", "3", "4")
//
//        val source: Single<Boolean> = Observable.fromArray(*data)
//            .map<String>(Shape::getShape)
//            .all(Shape.BALL::equals)
//
//        source.subscribe({ Log.d("결과", it.toString()) }, {})
        //.all(val -> Shape.BALL.equals(Shape.getShape(val)));


    }
}
