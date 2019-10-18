package main.kotin.com.hewking.kotlin.other

/**
 * @program: kotlinPractice
 * @description: ${description}
 * @author: hewking
 * @create: 2019-10-17 17:08
 **/

val a = 'a'

fun main() {
    var b: String? = "b"
    println(a)
    b = null
    b?.length

    // Elvis 操作符
    val l = if (b != null) b.length else -1
    // 以上等价
    val l2 = b?.length ?:-1

    // !! 非空断言运算符，(为NPE爱好者准备的 哈哈)
    // 将任何值转化为非空类型
}