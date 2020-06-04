package com.hewking.kotlin.coroutines.cancelation_timeout

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-04 16:03
 * @Created by jianhao
 */

fun foo() = runBlocking{

    val job = launch {
        delay(1000L)
        print("job")
    }

    delay(1300L)
    print("main:sleep")
    job.cancel()
    job.join()


}

fun bar() = runBlocking {
    var nextTime = System.currentTimeMillis()
    var i = 0
    val job = launch(Dispatchers.Default) {
        while (i < 10) {
            if (System.currentTimeMillis() - nextTime >= 500) {
                println("sleep time:${i++}")
                nextTime += 500
            }
        }
    }

    delay(1300L)
    println("main:sleep waiting")
    job.cancelAndJoin()
    println("exit")
}

fun foo1() = runBlocking {

    val job = launch {
        try {
            repeat(1000) {
                delay(500L)
                println("job:i'm sleep ${it}")
            }
        } finally {
            println("job can't runing")
        }

    }

    delay(1300L)
    println("main: waiting")
    job.cancelAndJoin()
    println("job is exiting")

}


fun foo2() = runBlocking {

    withTimeout(2000) {
        repeat(100) {
                delay(500L)
                println("job: index :$it")
        }
    }


}

suspend fun doSomethingUsefulOne() : Int {
    delay(500L)
    return 20
}

suspend  fun doSomethingUsefulTwo() : Int {
    delay(1500L)
    return 12
}

fun bar2() = runBlocking {

    val time = measureTimeMillis {
        val num = doSomethingUsefulOne() + doSomethingUsefulTwo()
        println("num:$num")
    }

    print("total time: $time")

}

fun bar3() = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }

        println("one: ${one.await()} two:${two.await()}")
    }

    println("total time:$time")
}


fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}

fun foo3() = runBlocking {
    val time = measureTimeMillis {
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()

        runBlocking {
            println("one: ${one.await()} two: ${two.await()}")
        }
    }

    println("total time: $time")
}

fun main(){
//    foo()
//    bar()
//    foo1()

//    foo2()

//    bar2()

//    bar3()

    foo3()
}
