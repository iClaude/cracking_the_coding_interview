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

private fun isOneEditAway(mStr1: String, mStr2: String): Boolean {
    if (abs(mStr1.length - mStr2.length) > 1) return false

    val str1 = if (mStr1.length > mStr2.length) mStr1 else mStr2
    val str2 = if (mStr1.length > mStr2.length) mStr2 else mStr1

    var edits = 0
    var i = 0
    var j = 0
    while (i in str1.indices && j in str2.indices) {
        if (str1[i] == str2[j]) {
            i++
            j++
            continue
        }

        if (i + 1 in str1.indices && j + 1 in str2.indices && str1[i + 1] == str2[j + 1]) j++
        edits++
        i++

        if (edits > 1) return false
    }

    edits += str1.length - i

    return edits < 2
}

