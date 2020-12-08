package leetcode

fun main() {
    val str = " questa è una stringa per un "
    println(str.replaceSpacesWith("pirla"))
}

fun String.replaceSpacesWith(otherStr: String): String {
    var numSpaces = 0
    for (char in this) {
        if (char == ' ') numSpaces++
    }

    val resultStr = Array(this.length + numSpaces * (otherStr.length - 1)) { ' ' }
    var i = 0
    for (char in this) {
        if (char != ' ') {
            resultStr[i++] = char
        } else {
            for (char2 in otherStr) {
                resultStr[i++] = char2
            }
        }
    }

    return resultStr.joinToString("") { it.toString() }
}

