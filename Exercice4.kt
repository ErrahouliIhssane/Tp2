package com.example.kotliny.tp2

import androidx.compose.ui.text.substring
class Circle()
fun main() {
    fun String.methode():String{
        var last:Int = this.length
        var  first:Int =0
        return  this.substring(first+1,last-1)

    }
    var t="Salma"
    println(t.methode())

    fun MutableList<Int>.Echange(x:Int,y:Int){
        var A=this.get(y)
        this.set(y,this.get(x))
        this.set(x,A)
    }
    fun Circle.perimetre(Rayon:Int){
        var perimetre= 2 * Math.PI *Rayon
    }

}