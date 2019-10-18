package main.kotin.com.hewking.kotlin.other

/**
 * @program: kotlinPractice
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-17 17:05
 **/

fun main(){
    val map = mutableMapOf<String,String>()
    map.put("a","1")
    map.putIfAbsent("b","2")

    for ((key,value) in map) {
        println("$key:$value")
    }
}