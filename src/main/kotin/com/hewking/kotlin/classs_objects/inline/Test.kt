package com.hewking.kotlin.classs_objects.inline

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-03 18:15
 * @Created by jianhao
 */

inline class Password(val password: String)

// 不存在Password对象，运行时只包括password 字符串
val securePassword = Password("this is password")

inline class Name(val name:String): Printable {
    val length: Int
    get() {
        return name.length
    }

    fun greet(){
        println("hello $name")
    }

    override fun preetyPrint():String {
        return "Lets $name"
    }
}

fun main(){
    val name = Name("tom")
    // 会被作为静态方法别调用
    // 限制，不能有init 代码块，不能有幕后字段 ，因为没有被实例化为一个对象
    name.greet()
}

// 允许继承接口
interface Printable {
    fun preetyPrint():String
}