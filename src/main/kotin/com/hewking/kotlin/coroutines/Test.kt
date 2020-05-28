package main.kotin.com.hewking.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

/**
 * @program: kotlinPractice
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-17 16:43
 **/

class Box<T>(t: T){
    var value : T = t
}


fun main(){
//  testLaunch()
//    testRunblocking()
//    testFuncRunBlocking()
    testReferenceJob()
}


fun testLaunch() {
    val startTime = System.currentTimeMillis()
    GlobalScope.launch {
        delay(1000)
        println("world")
        println("second time:" + System.currentTimeMillis().minus(startTime))
    }
    println("Hello")
    println("first time:" + System.currentTimeMillis().minus(startTime))
    Thread.sleep(2000)
}

fun testThread() {

}


fun testRunblocking() {
    GlobalScope.launch {
        delay(1000)
        println("world")
    }
    println("hello ")
    runBlocking {
        delay(2000L)
    }
}

/**
 * 测试runBlocking 阻塞主协程，内部协程执行
 */
fun testFuncRunBlocking() = runBlocking {
    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("hello ")
    delay(2000L)
}

fun testReferenceJob() = runBlocking{
    val job = GlobalScope.launch {
        delay(1000L)
        println("world")
    }
    println("hello ")
    job.join()
}
