package leetcode

import kotlin.math.abs

fun main() {
    val str1 = "pale"
    val str2 = "bake"
    println(areOneEditAway(str1, str2))
    println(areOneEditAwaySinglePass(str1, str2))
}

private fun areOneEditAway(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    return if (str1.length == str2.length) {
        checkReplace(str1, str2)
    } else {
        checkInsertOrDelete(str1, str2)
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

private fun checkInsertOrDelete(mStr1: String, mStr2: String): Boolean {
    val str1 = if (mStr1.length > mStr2.length) mStr1 else mStr2
    val str2 = if (mStr1.length > mStr2.length) mStr2 else mStr1

    var edits = 0
    var i = 0
    var j = 0
    while (i in str1.indices && j in str2.indices) {
        if (str1[i] == str2[j]) {
            j++
        } else {
            edits++
            if (edits > 1) return false
        }
        i++
    }

    return true
}

private fun areOneEditAwaySinglePass(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    return checkSinglePass(str1, str2)

}

private fun checkSinglePass(mStr1: String, mStr2: String): Boolean {
    val str1 = if (mStr1.length > mStr2.length) mStr1 else mStr2
    val str2 = if (mStr1.length > mStr2.length) mStr2 else mStr1

    var edits = 0
    var i = 0
    var j = 0
    while (i in str1.indices && j in str2.indices) {
        if (str1[i] == str2[j]) {
            j++
        } else {
            edits++
            if (edits > 1) return false
            if (str1.length == str2.length) j++
        }
        i++
    }

    return true
}