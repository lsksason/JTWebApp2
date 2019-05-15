package com.lskseason.jtwebapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*
import kotlin.Comparator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        HelloBtn.setOnClickListener { toast("Hello") }

        val x = 5
        val y = 6
        var v = if(x > y) x else y

        toast("value is $v" )

        for (index in 1..5 step 2)
            println("for value $index")
        for(index in 5 downTo 1 step 2)
            println(index)

        val a : IntArray = intArrayOf(1,2,3,4,5)
        for(index in a)
            println("Convert To Double ${index.toDouble()}")
        var c : Char = '\\'

        var arraytest = arrayOf(MyClass1(),
                MyClass1(),
                MyClass2())

        for(onitem in arraytest) {
//            println("funname=${onitem.fun1()}, string=${onitem}, basefun=${onitem.fun0()}")
            println("string=${onitem}, basefun=${onitem.fun0()}")

            when(onitem)
            {
                is MyClass1 -> onitem.fun1()//fun1 is MyClass1
                is MyClass2 -> onitem.fun1()//fun1 is MyClass2
                else -> println("MyClassBase")
            }
        }

        var pTestItem = TreeSet<String>( object : Comparator<String>
        {
            override fun compare(p0: String?, p1: String?): Int {
                //return (p0?.length ?: 0) - (p1?.length ?: 0)
                //return p0!!.compareTo(p1 ?: "")
                return  p0?.compareTo(p1 ?: "") ?: 0
            }
        })

        pTestItem.add("I am One")
        pTestItem.add("You are Two")
        pTestItem.add("They are Three")

        for (pOneItem in pTestItem)
            println(pOneItem)
    }
}

open class MyClassBase constructor(var vv : Int)
{
    fun fun0() = "I am fun0"
}

class MyClass1 constructor(var p1:Int = 1, var p2 : String = "test") : MyClassBase(0)
{
    fun fun1() = "I am fun1"

    override fun toString(): String {
        return "p1=$p1, p2=$p2"
    }
}

class MyClass2 constructor(p1:Int = 1, p2 : String = "test") : MyClassBase(1)
{
    fun fun1() = "I am fun1"
    fun fun2() = "I am fun2"
    override fun toString(): String {
        //return "p1=$p1, p2=$p2"
        return super.toString()
    }
}