package recap

import kotlin.math.abs

fun main() {
    val str1 = "pale"
    val str2 = "bake"
    println(areOneEditAway(str1, str2))
    println(areOneEditAwaySinglePass(str1, str2))
}

private fun areOneEditAway(str1: String, str2: String): Boolean =
    if (str1.length == str2.length) {
        areOneEditAwayCheckReplace(str1, str2)
    } else {
        areOneEditAwayCheckInsertAndDelete(str1, str2)
    }

private fun areOneEditAwayCheckReplace(str1: String, str2: String): Boolean {
    var diff = 0
    for (i in str1.indices) {
        if (str1[i] != str2[i]) diff++
        if (diff > 1) return false
    }

    return true
}

private fun areOneEditAwayCheckInsertAndDelete(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    val mStr1 = if (str1.length > str2.length) str1 else str2
    val mStr2 = if (str1.length > str2.length) str2 else str1

    var i1 = 0
    var i2 = 0
    while ((i1 - i2) < 2 && i2 in mStr2.indices) {
        if (mStr1[i1] == mStr2[i2]) {
            i2++
        }
        i1++
    }

    return (i1 - i2) < 2
}

private fun areOneEditAwaySinglePass(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    val mStr1 = if (str1.length > str2.length) str1 else str2
    val mStr2 = if (str1.length > str2.length) str2 else str1

    var i1 = 0
    var i2 = 0
    var diff = 0
    while ((i1 - i2) < 2 && i2 in mStr2.indices) {
        if (mStr1[i1] == mStr2[i2]) {
            i2++
        } else {
            diff++
            if (diff > 1) return false
            if (mStr1.length == mStr2.length) i2++
        }
        i1++
    }

    return (i1 - i2) < 2
}