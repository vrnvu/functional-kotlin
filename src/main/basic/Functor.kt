package main.basic

/**
 * Preserves identity
 * Composable
 */
fun main() {
    val base = Statistics(16, 180, 80)

    val modified = base.map { a -> a + 1 }
    val identity = base.map { a -> a }

    println(base == modified)
    println(base == identity)

    val composable = base.map { a -> a * 2 }.map { a -> a + 1 }

}

data class Statistics(val age: Int, val height: Int, val weight: Int) {
    fun map(f: (Int) -> Int) =
        Statistics(f(age), f(height), f(weight))
}