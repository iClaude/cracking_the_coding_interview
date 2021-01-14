package chapter01

import kotlin.math.abs

/*  One Away: There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check if
    they are one edit (or zero edits) away.
    EXAMPLE
    pale, ple -> true
    pales, pale -> true
    pale, bale -> true
    pale, bake -> false
 */

fun main() {
    val str1 = "apple"
    val str2 = "aple"
    println(isMaxOneEditAway(str1, str2))
    println(isMaxOneEditAwayCombined(str1, str2))
}

private fun isMaxOneEditAway(str1: String, str2: String): Boolean {
    if (abs(str1.length - str2.length) > 1) return false

    if (str1.length == str2.length) return checkReplace(str1, str2)

    return checkInsert(str1, str2)
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

private fun checkInsert(pStr1: String, pStr2: String): Boolean {
    val str1 = if (pStr1.length > pStr2.length) pStr1 else pStr2
    val str2 = if (pStr2.length < pStr1.length) pStr2 else pStr1

    var i = 0
    var j = 0
    var edits = 0
    while (i in str1.indices && j in str2.indices) {
        if (str1[i] != str2[j]) {
            edits++
            if (edits > 1) return false
        } else {
            j++
        }
        i++
    }

    return true
}

private fun isMaxOneEditAwayCombined(pStr1: String, pStr2: String): Boolean {
    if (abs(pStr1.length - pStr2.length) > 1) return false

    val str1 = if (pStr1.length > pStr2.length) pStr1 else pStr2
    val str2 = if (pStr2.length < pStr1.length) pStr2 else pStr1

    var i = 0
    var j = 0
    var edits = 0
    while (i in str1.indices && j in str2.indices) {
        if (str1[i] != str2[j]) {
            edits++
            if (edits > 1) return false
            if (str1.length == str2.length) j++
        } else {
            j++
        }
        i++
    }

    return true
}