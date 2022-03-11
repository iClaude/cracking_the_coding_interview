package chapter01

/*  URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith ", 13
    Output: "Mr%20John%20Smith" */

fun main() {
    val str = "Mr John Smith                             "
    println("urlified string = ${urlify(str, 13)}")
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