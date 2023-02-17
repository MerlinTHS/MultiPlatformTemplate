package io.kava.template

import io.mths.kava.extensions.cup
import io.mths.kava.extensions.getValue
import io.mths.kava.result.onFailure
import io.mths.kava.validator.validate

fun main() {
    validate {
        val coffee: Drink by maybeGetCoffee()

        println("Drink $coffee!")
    } onFailure {
        println("I want more coffee!")
    }
}

fun maybeGetCoffee() =
    cup { Drink.Tea }