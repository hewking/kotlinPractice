package com.hewking.kotlin.classs_objects.`typealias`

import com.hewking.kotlin.classs_objects.`object`.foo
import java.io.File
import java.nio.channels.NetworkChannel

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-03 18:05
 * @Created by jianhao
 */


// 缩减集合类型长度
typealias SetString = Set<String>

typealias FileTable<K> = MutableMap<K,MutableList<File>>

// 函数类型提供别名

typealias MyHandler = (Int,String,Any) -> Unit

typealias Predicate<T> = (t: T) -> Boolean

// 给内部类和嵌套类创建新名称

class A {
    class Inner
}

class B {
    inner class Inner
}

typealias AInner = A.Inner
typealias BInner = B.Inner

fun foo(predicate: Predicate<Int>) = predicate(42)

fun main(){

    println(foo{
        it > 0
    })

    val p : Predicate<Int> = {
        it > 0
    }
    println(listOf(-1,3).filter(p))

}