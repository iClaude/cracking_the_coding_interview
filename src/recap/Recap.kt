package recap

fun main() {
    val mStr = "iclaude"
    println(hasUniqueCharacters(mStr))
    println(hasUniqueCharacters2(mStr))
    println(hasUniqueCharacters3(mStr))
    println(hasUniqueCharacters4(mStr))
}

private fun hasUniqueCharacters(str: String): Boolean {
    if (str.length > 256) return false

    val chars = Array(256) { false }

    for (char in str) {
        if (chars[char.code]) {
            return false
        }
        chars[char.code] = true
    }

    return true
}

private fun hasUniqueCharacters2(str: String): Boolean {
    if (str.length > 256) return false

    val chars = hashMapOf<Char, Boolean>()

    for (char in str) {
        if (chars[char] == true) {
            return false
        }
        chars[char] = true
    }

    return true
}

private fun hasUniqueCharacters3(str: String): Boolean {
    if (str.length > 256) return false

    val strSorted = str.toCharArray().sorted()
    for (i in 0..strSorted.size - 2) {
        if (strSorted[i] == strSorted[i + 1]) {
            return false
        }
    }

    return true
}

private fun hasUniqueCharacters4(str: String): Boolean {
    var chars: Int = 0

    for (char in str) {
        val pos = char.code - 97
        if ((1 shl (pos) and chars) > 0) {
            return false
        }
        chars = 1 shl (pos) or chars
    }

    return true
}
