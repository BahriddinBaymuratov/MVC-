package com.example.mvc

import java.util.*

class MyModel : Observable() {
    private var counter = 0
    fun increment() {
        counter++
        setChanged()
        notifyObservers()
    }

    fun decrement() {
        if (counter > 0) {
            counter--
            setChanged()
            notifyObservers()
        }
    }

    fun getValue(): Int {
        return counter
    }

}