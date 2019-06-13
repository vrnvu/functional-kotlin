package basic

/**
 * The process of converting a function that takes multiple arguments into a function that takes them one at a time.
 */
fun main() {
    val add1: (Int) -> (Int) -> Int = { x -> { y -> x + y } }
    val add2 = { x: Int -> { y: Int -> x + y } }

    println(add1(2)(3))
    println(add2(2)(3))
}