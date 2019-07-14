package main.errorhandling

private fun arm(): Nuke = throw Exception("ARM exception.")
private fun aim(): Target = throw Exception("AIM exception.")
private fun launch(target: Target, nuke: Nuke): Impacted = Impacted

fun attackThrowable(): Impacted {
    val nuke = arm()
    val target = aim()
    return launch(target, nuke)
}

fun main() {
    attackThrowable()
}