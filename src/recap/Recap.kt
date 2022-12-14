package recap

fun main() {
    val str1 = "alfa"
    val str2 = "abba"
    println(isPermutationWithArray(str1, str2))
    println(isPermutationWithSorting(str1, str2))
}

private fun isPermutationWithArray(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val chars = Array(256) { 0 }

    for (char in str1) {
        chars[char.code]++
    }

    for (char in str2) {
        if (chars[char.code] == 0) return false
        chars[char.code]--
    }

    return true
}

private fun isPermutationWithSorting(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false

    val str1Sorted = str1.toCharArray().sorted().joinToString()
    val str2Sorted = str2.toCharArray().sorted().joinToString()

    return str1Sorted == str2Sorted
}

