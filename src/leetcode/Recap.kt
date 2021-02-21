package leetcode

fun main() {
    val str = "Mr John Smith                             ".toCharArray()
    val trueLen = 13
    urlify(str, trueLen)
    println(str.joinToString(""))
}

private fun urlify(str: CharArray, trueLen: Int) {
    var index = getFinalIndex(str, trueLen)

    for (i in trueLen - 1 downTo 0) {
        val char = str[i]
        if (char == ' ') {
            str[index--] = '0'
            str[index--] = '2'
            str[index--] = '%'
        } else {
            str[index--] = char
        }
    }
}

private fun getFinalIndex(str: CharArray, trueLen: Int): Int {
    var spaces = 0
    for (i in 0 until trueLen) {
        if (str[i] == ' ') spaces++
    }
    return trueLen - 1 + spaces * 2
}