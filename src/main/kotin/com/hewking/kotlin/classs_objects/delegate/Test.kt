package com.hewking.kotlin.classs_objects.delegate

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * @Classname Test
 * @Description TODO
 * @Date 2020-06-03 18:24
 * @Created by jianhao
 */

interface Base {
    fun print()
    fun printMessage()
}

class BaseImpl(val x: Int): Base{
    override fun print() {
        print("$x")
    }

    override fun printMessage() {
        print("123")
    }
}

class Derived(b: Base) : Base by b

class Derived2(b: Base): Base by b {
    override fun printMessage() {
        print("abc")
    }
}

fun main(){
    val impl = BaseImpl(10)
    Derived(impl).print()

    Derived2(impl).printMessage()

    println(Example().p)

    println(lazyValue)

    val user = User()
    user.name = "first"
    user.name = "second"

    val student = Student(mutableMapOf("name" to "tom","age" to 18))
    println(student.name)
    println(student.age)
}

// 属性委托

class Delegate{
    operator fun getValue(thisRef: Any?,property: KProperty<*>):String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?,property:KProperty<*>,value:String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example {
    var p : String by Delegate()
}

val lazyValue  by lazy {
    println("lazyvalue")
    "Hello"
}

class User {
    var name :String by Delegates.observable("<no name>")  {
        _,old,new ->
        println("old:$old -> new: $new")
    }
}

class Student(val map: MutableMap<String,Any?>){
    var name:String by map
    val age:Int by map
}

class Foo {
    fun isValid():Boolean {
        return true
    }

    fun doSomething(){

    }
}

fun example(computeFoo: () -> Foo){
    val memoizedFoo by lazy(computeFoo)
    if (memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}