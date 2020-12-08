package chapter01

/*
    1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including
    the null character.)
 */

private fun reverseStringIterative(str: String): String {
    val arrChars = str.toCharArray()
    for (i in 0 until arrChars.size / 2) {
        swap(arrChars, i, arrChars.size - 2 - i)
    }
    return arrChars.joinToString("") {
        it.toString()
    }
}

private fun reverseArrayRecursive(arr: CharArray, i1: Int) {
    if (i1 == arr.size / 2) return

    swap(arr, i1, arr.size - 2 - i1)
    reverseArrayRecursive(arr, i1 + 1)
}

private fun swap(arr: CharArray, i1: Int, i2: Int) {
    val tmp = arr[i1]
    arr[i1] = arr[i2]
    arr[i2] = tmp
}

// test
fun main() {
    // iterative
    val str = "abcd\u0000"
    println("original str: $str")
    println("reversed string: ${reverseStringIterative(str)}")

    // recursive
    val arr2 = charArrayOf('a', 'b', 'c', 'd', 'e', '\u0000')
    println("original array: ${arr2.contentToString()}")

    reverseArrayRecursive(arr2, 0)
    println("reversed array: ${arr2.contentToString()}")
}