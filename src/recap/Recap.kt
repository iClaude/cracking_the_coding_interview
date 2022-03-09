package recap

fun String.isPermutationOf(other: String): Boolean {
    if (length != other.length) return false

    val letters = Array(256) { 0 }
    for (letter in this) {
        letters[letter.code]++
    }

    for (letter in other) {
        letters[letter.code]--
        if (letters[letter.code] < 0) return false
    }

    return true
}

fun String.isPermutationOfWithSorting(other: String): Boolean {
    if (length != other.length) return false

    return toCharArray().sort() == other.toCharArray().sort()
}

fun main() {
    val str1 = "abc"
    val str2 = "cbc"
    println("is \"$str2\" a permutation of \"$str1\"? ${str2.isPermutationOf(str1)}")
    println("is \"$str2\" a permutation of \"$str1\"? ${str2.isPermutationOfWithSorting(str1)}")
}