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

// 函数类型接口
class IntTransformer: (Int) -> Int {
    override fun invoke(p1: Int): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

val intFunction: (Int) -> Int = IntTransformer()

val repeatFunc: String.(Int) -> String = {it ->
    this.repeat(it)
}

// 两个参数的函数，和上面的ex函数等价
val twoParameters : (String,Int) -> String = repeatFunc

val stringPlus : (String,String) -> String = String::plus

// lambda 表达式
val foo = {
    x: Int,y : Int -> x + y
}

fun bar(z: Int,baz: (Int,Int) -> Int):Int {
    return baz(z,2)
}

val qux = bar(3, foo)

val foo2 = fun(x:Int,y:Int):Int {
    return x + y
}

fun main(){
    println(result)
    println(stringPlus("<-","->"))
}