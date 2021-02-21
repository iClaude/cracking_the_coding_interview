package leetcode

import kotlin.math.abs

fun main() {
    val str1 = "pales"
    val str2 = "paes"
    println(areOneEditAway(str1, str2))
}

private fun areOneEditAway(str1: String, str2: String): Boolean {
    return if (str1.length == str2.length) {
        checkReplace(str1, str2)
    } else {
        checkInsertOrRemove(str1, str2)
    }
}

private fun checkReplace(str1: String, str2: String): Boolean {
    var edits = 0
    for (i in str1.indices) {
        if (str1[i] != str2[i]) {
            edits++
            if (edits > 1) return false
        }
    }
    return true
}

private fun checkInsertOrRemove(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    val mStr1 = if (str1.length > str2.length) str1 else str2
    val mStr2 = if (str1.length > str2.length) str2 else str1

    var p1 = 0
    var p2 = 0
    while (p1 in mStr1.indices && p2 in mStr2.indices) {
        if (mStr1[p1] == mStr2[p2]) {
            p1++
            p2++
        } else {
            p1++
            if (p1 - p2 > 1) return false
        }
    }
    return true
}