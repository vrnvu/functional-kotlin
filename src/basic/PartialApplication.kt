package basic

/**
 * Partially applying a function means creating a new function by pre-filling some of the arguments to the original function.
 * In Kotlin we need a helper function
 */
fun main() {
    val add: (Int) -> ((Int) -> Int) = { x -> { y -> x + y } }
    val increment = add(1)
    val incrementTwo = increment(2)
    val incrementFive = increment(5)

    println(add)
    println(incrementTwo)
    println(incrementFive)
}

