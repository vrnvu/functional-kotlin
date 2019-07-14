package main.eithers

import arrow.core.Either
import arrow.core.flatMap

sealed class Error {
    object NotANumber : Error()
    object NoZeroReciprocal : Error()
}

fun parse(s: String): Either<Error, Int> =
        if (s.matches(Regex("-?[0-9]+"))) Either.Right(s.toInt())
        else Either.Left(Error.NotANumber)

fun reciprocal(i: Int): Either<Error, Double> =
        if (i == 0) Either.Left(Error.NoZeroReciprocal)
        else Either.Right(1.0 / i)

fun stringify(d: Double): String = d.toString()

fun magic(s: String): Either<Error, String> =
        parse(s).flatMap { reciprocal(it) }.map { stringify(it) }

fun main() {
    val toPrint = when (val result = magic("0")) {
        is Either.Left -> when (result.a) {
            Error.NotANumber -> "Not a number"
            Error.NoZeroReciprocal -> "No Zero Reciprocal"
        }
        is Either.Right -> result.b
    }
    println(toPrint)
}