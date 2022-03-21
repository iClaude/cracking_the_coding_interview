package recap

import kotlin.math.abs
import kotlin.math.log10

fun main() {
    val str = "aaabbcccccdd"
    println("compressed string = ${compressString(str)}")
    println("compressed string = ${compressString2(str)}")

}

private fun compressString(str: String): String {
    val sb = StringBuilder(str[0].toString())

    var start = 0
    var i = 1
    while (i in str.indices) {
        if (str[i] != str[start]) {
            sb.append(i - start)
            sb.append(str[i])
            start = i
        }
        i++
    }
    sb.append(i - start)

    return if (sb.length < str.length) {
        sb.toString()
    } else {
        str
    }
}

private fun compressString2(str: String): String {
    val compressedLength = computeCompressedLength(str)
    if (compressedLength >= str.length) return str

    val sb = StringBuilder(compressedLength).also {
        it.append(str[0])
    }
    var start = 0
    var i = 1
    while (i in str.indices) {
        if (str[i] != str[start]) {
            sb.append(i - start)
            sb.append(str[i])
            start = i
        }
        i++
    }
    sb.append(i - start)

    return sb.toString()
}

private fun computeCompressedLength(str: String): Int {
    var len = 0

    var start = 0
    var i = 1
    while (i in str.indices) {
        if (str[i] != str[start]) {
            len += 1 + (i - start).length()
            start = i
        }
        i++
    }
    len += 1 + (i - start).length()

    return len
}

fun Int.length() = when (this) {
    0 -> 1
    else -> log10(abs(toDouble())).toInt() + 1
}