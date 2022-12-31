package recap

fun main() {
    val str = "aaabbc"
    println(compressString(str))
    println(compressStringWithLengthCheck(str))
    println(getCompressedLength(str))
}

private fun compressString(str: String): String {
    if (str.length < 3) return str

    val sb = StringBuilder()
    var letter = str[0]
    var count = 1
    sb.append(letter)
    for (i in 1..str.lastIndex) {
        if (str[i] == letter) {
            count++
        } else {
            sb.append(count)
            letter = str[i]
            sb.append(letter)
            count = 1
        }
    }
    sb.append(count)

    return if (sb.length < str.length) {
        sb.toString()
    } else {
        str
    }
}

private fun compressStringWithLengthCheck(str: String): String {
    val compressedLength = getCompressedLength(str)
    if (compressedLength >= str.length) return str

    val sb = StringBuilder(compressedLength)
    var letter = str[0]
    var count = 1
    sb.append(letter)
    for (i in 1..str.lastIndex) {
        if (str[i] == letter) {
            count++
        } else {
            sb.append(count)
            letter = str[i]
            sb.append(letter)
            count = 1
        }
    }
    sb.append(count)

    return if (sb.length < str.length) {
        sb.toString()
    } else {
        str
    }
}

private fun getCompressedLength(str: String): Int {
    if (str.length < 3) return str.length

    var letter = str[0]
    var count = 1
    var compressedLength = 0
    for (i in 1..str.lastIndex) {
        if (str[i] == letter) {
            count++
        } else {
            compressedLength += 1 + count.toString().length
            letter = str[i]
            count = 1
        }
    }
    compressedLength += 2

    return compressedLength
}