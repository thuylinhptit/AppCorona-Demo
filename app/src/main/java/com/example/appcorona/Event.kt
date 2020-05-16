package com.example.appcorona

open  class Event <out T>(private  val content: T){
    var consumed = false
    private set

    fun consume(): T?{
        return if ( consumed ){
            null
        }
        else{
            consumed = true
            content
        }
    }

    override fun hashCode(): Int {
        var result = content?.hashCode() ?: 0
        result = 31 * result + consumed.hashCode()
        return result
    }
}