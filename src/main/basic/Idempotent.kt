package main.basic

import kotlin.math.abs

/**
 * A function is idempotent if reapplying it to its result does not produce a different result.
 */
fun main() {
    val list = listOf(1, 2, 3)
    val sorted = list.sorted().sorted()

    val value = -2
    val absoluteValue = abs(abs(value))
}