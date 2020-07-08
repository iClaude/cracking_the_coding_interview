package chapter01

/*
   1.8 Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write
   code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).

   First check that the 2 strings have the same length, otherwise one can't be a rotation of the other.
   Then create a new concat string str1 + str1 and check that string2 is a substring of it: if that is true, string2 is a rotation
   of string1.
*/

fun main() {
    val str1 = "waterbottle"
    val str2 = "ottlewaterb"
    println("is $str2 a rotation of $str1? -> ${str2.isRotationOf(str1)}")
}

fun String.isRotationOf(str2: String): Boolean {
    if (this.length != str2.length) return false

    val strConcat = this + this
    return str2.isSubstringOf(strConcat)
}

fun String.isSubstringOf(str2: String) =
    str2.contains(this)