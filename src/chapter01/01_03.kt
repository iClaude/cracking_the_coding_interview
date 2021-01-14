package chapter01

/*  PROBLEM
    URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
    has sufficient space at the end to hold the additional characters, and that you are given the "true"
    length of the string. (Note: If implementing in Java, please use a character array so that you can
    perform this operation in place.)
    EXAMPLE
    Input: "Mr John Smith ", 13
    Output: "Mr%20John%20Smith" */

/*  ALGORITHM
    Count the number of spaces in the original string.
    Create an array of characters of the final size: size of the original string + number of spaces
    * 2 (to make room for %20).
    Loop over the original string and copy each character in the new array, or %20 in case of spaces,
    incrementing an index to keep track of the position in the new array.
    Finally convert the array in a string. */

fun main() {
    val str1 = " a bc  d "
    println("new string -> ${replaceSpaces(str1)}")
    println("new string -> ${str1.replaceSpacesWith("%20")}")
}

private fun replaceSpaces(str1: String): String {
    var spaces = 0
    for (char in str1) {
        if (char == ' ') spaces++
    }
    val newLen = str1.length + spaces * 2

    val newStrArr = Array(newLen) { ' ' }
    var i = 0
    for (char in str1) {
        if (char != ' ') {
            newStrArr[i++] = char
        } else {
            newStrArr[i++] = '%'
            newStrArr[i++] = '2'
            newStrArr[i++] = '0'
        }
    }

    return newStrArr.joinToString("")
}

// more general solution
private fun String.replaceSpacesWith(otherStr: String): String {
    val numSpaces = this.count {
        it == ' '
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