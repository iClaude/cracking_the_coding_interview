package leetcode

fun main() {
    val str = "ddd"
    println("are characters unique? ${areCharsUnique3(str)}")
}

fun areCharsUnique(str: String): Boolean {
    val arrChars = Array(255) { 0 }
    for (char in str) {
        arrChars[char.toInt()]++
        if (arrChars[char.toInt()] > 1) return false
    }
    return true
}

fun areCharsUnique2(str: String): Boolean {
    for (i in str.indices) {
        for (j in i + 1 until str.length) {
            if (str[i] == str[j]) return false
        }
    }
    return true
}

fun areCharsUnique3(str: String): Boolean {
    val strSorted = str.toCharArray().sortedArray()
    for (i in 1 until strSorted.size) {
        if (strSorted[i] == strSorted[i - 1]) return false
    }
    return true
}