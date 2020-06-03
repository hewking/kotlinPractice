package com.hewking.kotlin.functions_lambdas.function

import com.sun.corba.se.impl.orbutil.graph.Graph
import sun.security.provider.certpath.Vertex

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-03 23:39
 * @Created by jianhao
 */

// 函数声明
fun double(x:Int):Int {
    return x * 2
}

// 函数调用
var result = double(2)

// 函数参数
fun powerOf(number: Int,exponent: Int): Int {
    return number
}

// 默认参数
fun read(b: Array<Byte>,off:Int = 0,len: Int = 0) {

}

open class A {
    open fun foo(i: Int = 10){

    }
}

class B : A() {
    // override 的函数不可以覆盖 默认参数
    override fun foo(i: Int) {
        super.foo(i)
    }

    fun foo1(bar: Int = 1,baz: Int) {}

    fun foo2(){
        foo1(baz = 2)
    }
}

fun <T> asList(vararg ts: T):List<T> {
    val list = mutableListOf<T>()
    for (t in ts) {
        list.add(t)
    }
    return list
}

var a = arrayOf(1,2,3)

val list = asList(1,2,*a,3)

// 中缀函数
infix fun Int.shl(x: Int): Int {
    return x
}

fun foo(){
    1 shl 2
    1.shl(2)
}

fun dfs(graph: Graph) {
    fun dfs(current: Vertex,visited: MutableSet<Vertex>) {
        if (!visited.add(current)) return
//        for (v in current.)
    }
}

// 尾递归优化
val eps = 1E-10

tailrec fun findFixPoint(x:Double = 1.0):Double {
    return if (Math.abs(x - Math.cos(x)) < eps) x else findFixPoint(Math.cos(x))
}