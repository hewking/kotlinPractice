package com.hewking.kotlin.classs_objects.inline

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JComponent

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-03 17:39
 * @Created by jianhao
 */

open class A(a: Int) {
    public open val y = 10
}

interface B{}

val ab: A = object: A(1),B {
    override val y = 1
}

fun foo():Int{
    val obj = object {
        var x = 0
        var y = 0
    }

    return obj.x + obj.y
}

class C {
    private fun foo() = object {
        val x:String = "x"
    }

    fun publicFoo() = object  {
        val x:String = "x"
    }

    fun bar(){
        foo().x // 在局部，和私有域可以访问到object的类型
//        publicFoo().x fail,共有方法无法返回的object是超类型
//        是Any类型，所以无法访问到x
    }
}


fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    // object生命可以访问到，包含它的作用域中的自由变量，就跟js中的闭包概念相似
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
}

// 对象表达式
object DataProviderManager {
    fun registerDataProvider(){

    }

    fun getAllDataProviders(){

    }
}

// 对象表达式可以有超类型
object DefaultListener: MouseAdapter(){
    override fun mouseClicked(e: MouseEvent?) {
        super.mouseClicked(e)
    }
}

interface Factory<T> {
    fun create():T
}

// 伴生对象
class MyClass{
    companion object : Factory<MyClass>{
        override fun create() = MyClass()
    }
}

val instance = MyClass.create()

val x = MyClass.Companion // 这是啥情况