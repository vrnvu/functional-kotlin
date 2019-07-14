package main.basic

/**
 * Function that returns true or false given a value
 */
fun main() {
    val predicate: (Int) -> Boolean = { a -> a % 2 == 0 }
    val filtered = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(filtered.filter(predicate))
}