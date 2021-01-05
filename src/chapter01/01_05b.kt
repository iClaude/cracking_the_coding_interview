package chapter01

/*
    String Compression: Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    "compressed" string would not become smaller than the original string, your method should return
    the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */

private fun compressString(str: String): String {
    val sb = StringBuilder()
    var i = 0
    var len = 0
    while (i in str.indices) {
        sb.append(str[i])
        var j = i + 1
        while (j in str.indices && str[j] == str[i]) {
            j++
        }
        sb.append("${j - i}")
        len += 1 + "${j - i}".length
        if (len >= str.length) return str
        i = j
    }

    return sb.toString()
}