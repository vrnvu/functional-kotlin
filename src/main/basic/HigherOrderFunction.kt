package main.basic

/**
 * A function which takes a function as an argument and/or returns a function.
 */
fun main() {
    // Function 1
    val double: (Int) -> Int = { a -> a * 2 }

    // Function 2
    val triple: (Int) -> Int = { a -> a * 3 }

    // Higher Order Function
    val addOne: ((Int) -> Int, Int) -> Int = { f, a -> f(a) + 1 }
    println(addOne(double, 2))
    println(addOne(triple, 2))
}