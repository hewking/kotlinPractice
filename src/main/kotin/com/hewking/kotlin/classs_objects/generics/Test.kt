package main.kotin.com.hewking.kotlin.classs_objects

/**
 * @program: kotlinPractice
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-17 16:43
 **/

interface Source<out T>{
    fun next(): T
}

fun demo(strs : Source<String>){
    val source: Source<Any> = strs
    source.next()
}

/**
 * 暂时可以这么理解，消费者是作为输入，比如这里a作为参数
 * 是T类型 则只能用 in,Source接口，T 作为next的返回值，作为
 * 生产者 就需要用到out
 */
interface Comparable<in T> {
    fun compare(a: T): Boolean
}

fun demo2(x: Comparable<Number>){
    x.compare(1.0)

    val y: Comparable<Double> = x
}

/**
 * 泛型投影
        **/
class Array<T>(val size: Int){
    fun get(i : Int) : T{
        return 1 as T
    }

    fun set(value : T) {

    }

}


fun copy(from: Array<Any>,to : Array<Any>){
    assert(from.size == to.size)
    for (i in 0 until from.size) {
//        to[i] = from[i]
    }
}
