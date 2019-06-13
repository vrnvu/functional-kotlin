package basic

fun main() {
    val double: (Int) -> Int = { x -> x * 2 }
    val increment: (Int) -> Int = { x -> x + 1 }
    val doubleAndIncrement = of(double, increment);
    val incrementAndDouble = of(increment, double);

    println(doubleAndIncrement(3))
    println(incrementAndDouble(3))
}

fun <A, B, C> of(f: (A) -> B, g: (B) -> C): (A) -> C {
    return { x -> g(f(x)) }
}