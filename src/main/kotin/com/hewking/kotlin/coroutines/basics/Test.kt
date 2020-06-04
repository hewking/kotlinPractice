package com.hewking.kotlin.coroutines.basics

import kotlinx.coroutines.*
import kotlin.concurrent.thread

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-04 14:16
 * @Created by jianhao
 */

fun baz() {
    GlobalScope.launch {
        doWorld()
    }
    print("hello ")
    Thread.sleep(2000L)
}

fun foo() {
    thread {
        Thread.sleep(1000)

    }
}

fun bar() {
    GlobalScope.launch {
        doWorld()
    }
    runBlocking {
        println("hello ")
        delay(2000L)
    }
}

fun bar2() = runBlocking {
    GlobalScope.launch {
        doWorld()
    }
    print("hello ")
    delay(2000L)
}

fun quz() = runBlocking{
    val job = GlobalScope.launch {
        doWorld()
    }
    println("hello ")
    job.join()
}

private suspend fun doWorld() {
    delay(1000L)
    print("world")
}


fun foo2() = runBlocking{

    launch {
        delay(1000L)
        print("B")
    }

    coroutineScope {
        launch {
            delay(2000L)
            print("C")
        }

        delay(500L)
        print("D")
    }

    print("A")

}

fun main() {
//    bar()
//bar2()
//    quz()
    foo2() // DBCA
}