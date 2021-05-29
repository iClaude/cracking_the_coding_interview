package recap

import kotlin.math.abs

fun main() {
    val str1 = "pale"
    val str2 = "bake"

    println(areMaxOneEditAway(str1, str2))


}

private fun areMaxOneEditAway(str1: String, str2: String): Boolean {
    /*return if (str1.length == str2.length) {
        checkReplace(str1, str2)
    } else {
        checkInsertOrDelete(str1, str2)
    }*/

    return checkEdits(str1, str2)
}

private fun checkReplace(str1: String, str2: String): Boolean {
    var diff = 0
    for (i in str1.indices) {
        if (str1[i] != str2[i]) {
            diff++
            if (diff > 1) return false
        }
    }

    return true
}

private fun checkInsertOrDelete(mStr1: String, mStr2: String): Boolean {
    if (abs(mStr1.length - mStr2.length) > 1) return false

    val str1 = if (mStr1.length > mStr2.length) mStr1 else mStr2
    val str2 = if (mStr1.length > mStr2.length) mStr2 else mStr1

    var i = 0
    var j = 0

    while (j in str2.indices) {
        if (str1[i] == str2[j]) {
            j++
        }
        i++
        if (i - j > 1) return false
    }

    return i - j <= 1
}

private fun checkEdits(mStr1: String, mStr2: String): Boolean {
    val str1 = if (mStr1.length > mStr2.length) mStr1 else mStr2
    val str2 = if (mStr1.length > mStr2.length) mStr2 else mStr1

    var i = 0
    var j = 0
    var diff = 0

    while (j in str2.indices) {
        if (str1[i] != str2[j]) {
            diff++
            if (diff > 1) return false
            if (str1.length == str2.length) j++
        } else {
            j++
        }
        i++
    }

    return true
}