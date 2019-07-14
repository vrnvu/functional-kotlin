package main.basic

/**
 * Writing functions where the definition does not explicitly identify the arguments used.
 */
fun main() {
    val add: (Int) -> (Int) -> Int = { a -> { b -> a + b } }
    val map: ((Int) -> (Int)) -> (List<Int>) -> List<Int> = { f -> { l -> l.map(f) } }
    val increment = map(add(1))
    println(increment(listOf(1, 2 ,3)))
}
