package main.kotin.com.hewking.kotlin.other

/**
 * @program: kotlinPractice
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-17 16:46
 **/

data class Point(val x: Int,val y: Int)

operator fun Point.unaryMinus() = Point(-x,-y)

val point = Point(10,20)

fun main(){
    print(-point)
}