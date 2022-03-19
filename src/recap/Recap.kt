package recap

import kotlin.math.abs

fun main() {
    val str1 = "pale"
    val str2 = "bake"
    println("Are the 2 strings one edit away? ${oneEditAway(str1, str2)}")
    println("Are the 2 strings one edit away (one pass)? ${oneEditAwayOnePass(str1, str2)}")

}

private fun oneEditAway(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    return if (str1.length == str2.length) {
        checkWithEqualLength(str1, str2)
    } else {
        checkWithDifferentLength(str1, str2)
    }
}

private fun checkWithEqualLength(str1: String, str2: String): Boolean {
    var diff = 0
    for (i in str1.indices) {
        if (str1[i] != str2[i]) diff++
        if (diff > 1) return false
    }
    return true
}

private fun checkWithDifferentLength(str1: String, str2: String): Boolean {
    val mStr1 = if (str1.length > str2.length) str1 else str2
    val mStr2 = if (str1.length > str2.length) str2 else str1

    var i = 0
    var j = 0
    while (i < mStr1.length && j < mStr2.length) {
        if (mStr1[i] == mStr2[j]) j++
        i++

        if (i - j > 1) return false
    }

    return true
}

private fun oneEditAwayOnePass(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    val mStr1 = if (str1.length >= str2.length) str1 else str2
    val mStr2 = if (str1.length >= str2.length) str2 else str1

    var i = 0
    var j = 0
    var diff = 0
    while (i < str1.length && j < str2.length) {
        if (mStr1[i] != mStr2[j]) {
            diff++
            if (diff > 1) return false
            if (mStr1.length == mStr2.length) j++
        } else {
            j++
        }
        i++
    }

    return true
}