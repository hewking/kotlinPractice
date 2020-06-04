package com.hewking.kotlin.functions_lambdas.lambda

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-04 00:38
 * @Created by jianhao
 */

fun <T,R> Collection<T>.fold(
        initial: R,
        combine:(T,R) -> R
):R{
    var acc = initial
    for (t in this) {
        acc = combine(t,acc)
    }
    return acc
}

val list = listOf(1,2,3,4,5)

val result = list.fold(0) {
    acc,i ->
     acc + i
}

fun main(){
    println(result)
}