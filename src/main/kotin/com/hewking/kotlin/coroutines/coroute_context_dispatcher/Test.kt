package com.hewking.kotlin.coroutines.coroute_context_dispatcher

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-04 16:44
 * @Created by jianhao
 */

fun foo(){

    runBlocking {
        launch {
            println("Blocking : i'm working at ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined : i'm working at ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default : i'm working at ${Thread.currentThread().name}")
        }

        launch(newSingleThreadContext("MyThrad")) {
            println("newThread : i'm working at ${Thread.currentThread().name}")
        }
    }
}

fun main(){
    foo()
}