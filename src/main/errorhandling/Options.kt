package main.errorhandling

import arrow.core.None
import arrow.core.Option
import arrow.core.Some
import arrow.core.extensions.option.monad.binding

private fun arm(): Option<Nuke> = Some(Nuke)
private fun aim(): Option<Target> = None
private fun launch(target: Target, nuke: Nuke): Option<Impacted> = Some(Impacted)

fun attackOption() =
        binding {
            val (nuke) = arm()
            val (target) = aim()
            val (impact) = launch(target, nuke)
            impact
        }

fun main() {
    val result = when (attackOption()) {
        is Some -> "Some"
        is None -> "None"
    }
    println(result)
}

