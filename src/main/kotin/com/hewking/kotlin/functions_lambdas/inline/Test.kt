package com.hewking.kotlin.functions_lambdas.inline

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-04 11:34
 * @Created by jianhao
 */


inline fun foo(bar: () -> Unit ,noinline baz: () -> Unit) {

}

// 具体化类型参数
inline fun <reified T> members() = T::class.members

fun main(){
    println(members<StringBuffer>().joinToString("/n"))
}