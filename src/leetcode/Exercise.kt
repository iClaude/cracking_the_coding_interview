package leetcode

fun main() {
    val str = "mamma"
    println(str.isAnagramOf("mammo"))
}

fun String.isAnagramOf(otherStr: String): Boolean {
    if (this.length != otherStr.length) return false

    val charsCount = Array(256) { 0 }
    for (char in this) {
        charsCount[char.toInt()]++
    }
    for (char in otherStr) {
        val newValue = --charsCount[char.toInt()]
        if (newValue < 0) return false
    }

    return true
}

