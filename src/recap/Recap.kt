package recap

fun main() {
    val myStr = "Iosonoleggenda                               "
    println("urlified string = ${urlify(myStr, 14)}")
}

fun urlify(str: String, len: Int): String {
    var spaces = 0
    for (i in 0 until len) {
        if (str[i] == ' ') spaces++
    }
    if (spaces == 0) return str

    val strArray = str.toCharArray()
    var pos = len + 2 * spaces - 1
    for (i in len - 1 downTo 0) {
        if (strArray[i] != ' ') {
            strArray[pos--] = strArray[i]
        } else {
            strArray[pos--] = '0'
            strArray[pos--] = '2'
            strArray[pos--] = '%'
        }
    }

    return strArray.joinToString("")
}