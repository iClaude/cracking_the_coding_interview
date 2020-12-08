package leetcode

fun main() {
    val str = "aaabbbcccdeeeaabfffgeeah"
    println("string without duplicateds = ${removeDuplicates(str)}")
}

fun removeDuplicates(str: String): String {
    val strResult = StringBuilder()
    val characters = Array(256) { false }
    for (char in str) {
        if (!characters[char.toInt()]) {
            characters[char.toInt()] = true
            strResult.append(char)
        } else {
            continue
        }
    }
    return strResult.toString()
}

