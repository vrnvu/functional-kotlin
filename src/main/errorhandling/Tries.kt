package main.errorhandling

import arrow.core.Failure
import arrow.core.Success
import arrow.core.Try
import arrow.core.extensions.`try`.monad.binding

private fun arm(): Try<Nuke> = Success(Nuke)
private fun aim(): Try<Target> = Success(Target)
private fun launch(target: Target, nuke: Nuke): Try<Impacted> = Success(Impacted)

fun attackWithTry() =
        binding {
            val (nuke) = arm()
            val (target) = aim()
            val (impact) = launch(target, nuke)
            impact
        }


fun main() {
    when (val result = attackWithTry()) {
        is Success -> println("Success")
        is Failure -> result.exception
    }
}