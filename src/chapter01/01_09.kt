package chapter01

/*  String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring
    of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
    call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat"). */

fun main() {
    val str1 = "waterbottle"
    val str2 = "erbottlewat"
    println("is $str2 a rotation of $str1? -> ${str2.isRotationOf(str1)}")
}

private fun String.isRotationOf(otherStr: String): Boolean {
    if (this.length != otherStr.length) return false

    return otherStr.isSubstringOf("$this$this")
}

private fun String.isSubstringOf(otherStr: String) =
        otherStr.contains(this)