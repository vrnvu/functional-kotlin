package basic

/**
 * A function which takes a function as an argument and/or returns a function.
 */
fun main() {
    // Function
    val sum: (Int, Int) -> Int = { a, b -> a + b }
    // Higher Order Function
    val operator = {}
    println(sum(2, 3))
}