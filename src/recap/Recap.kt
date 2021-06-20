package recap

fun main() {
    println("a".isRotationOf(""))
}

fun String.isRotationOf(str: String) =
    this.length == str.length && this.isSubstringOf("$str$str")

fun String.isSubstringOf(str: String) =
    str.indexOf(this) > -1
