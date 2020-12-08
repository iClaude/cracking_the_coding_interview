package leetcode

fun main() {
    val str = "abcd\u0000"
    println("string reversed? ${reverseString(str)}")
}

fun reverseString(str: String): String {
    val arrChars = str.toCharArray()
    for (i in 0 until arrChars.size / 2) {
        val tmp = arrChars[i]
        arrChars[i] = arrChars[arrChars.size - 2 - i]
        arrChars[arrChars.size - 2 - i] = tmp
    }
    return arrChars.joinToString("") {
        it.toString()
    }
}

