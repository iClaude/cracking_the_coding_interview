package chapter01

/*
    1.2 Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including
    the null character.)
 */

private fun reverseArrayIterative(arr: CharArray) {
    for (i in 0 until arr.size / 2) {
        swap(arr, i, arr.size - 2 - i)
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
    val arr = charArrayOf('a', 'b', 'c', 'd', '\u0000')
    println("original array: ${arr.contentToString()}")

    reverseArrayIterative(arr)
    println("reversed array: ${arr.contentToString()}")

    // recursive
    val arr2 = charArrayOf('a', 'b', 'c', 'd', 'e', '\u0000')
    println("original array: ${arr2.contentToString()}")

    reverseArrayRecursive(arr2, 0)
    println("reversed array: ${arr2.contentToString()}")
}