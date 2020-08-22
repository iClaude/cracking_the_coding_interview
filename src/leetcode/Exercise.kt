package leetcode

fun main() {
    val arr = charArrayOf('a', 'b', 'c', 'd', '\u0000')
    println("original array: ${arr.contentToString()}")

    reverseArray(arr)
    println("reversed array: ${arr.contentToString()}")
}

private fun reverseArray(arr: CharArray) {
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