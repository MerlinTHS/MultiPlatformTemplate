package io.kava.template

enum class Drink {
    Coffee,
    Tea
}

fun Drink.isCoffee(): Boolean =
    this == Drink.Coffee