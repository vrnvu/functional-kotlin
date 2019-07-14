package main.errorhandling

import arrow.core.Either
import arrow.core.Left
import arrow.core.Right
import arrow.core.extensions.either.monad.binding


sealed class NukeException {
    object SystemOffline : NukeException()
    object RotationNeedsOil : NukeException()
    data class MissedByMeters(val meters: Int) : NukeException()
}

typealias SystemOffline = NukeException.SystemOffline
typealias RotationNeedsOil = NukeException.RotationNeedsOil
typealias MissedByMeters = NukeException.MissedByMeters

private fun arm(): Either<SystemOffline, Nuke> = Right(Nuke)
private fun aim(): Either<RotationNeedsOil, Target> = Right(Target)
private fun launch(target: Target, nuke: Nuke): Either<MissedByMeters, Impacted> = Left(MissedByMeters(100))

fun attackWithEither(): Either<NukeException, Impacted> =
        binding {
            val (nuke) = arm()
            val (target) = aim()
            val (impact) = launch(target, nuke)
            impact
        }

fun main() {
    val result = when (val either = attackWithEither()) {
        is Either.Left -> either.a
        is Either.Right -> either.b
    }
    println(result)
}
