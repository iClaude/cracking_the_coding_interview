package recap

fun main() {
    val str = "abbac"
    println(isPalindromePermutationWithArray(str))
    println(isPalindromePermutationWithArray2(str))
    println(isPalindromePermutationWithBitVector(str))
}

private fun isPalindromePermutationWithArray(str: String): Boolean {
    val chars = Array(26) { 0 }
    for (char in str) {
        if (char != ' ') {
            chars[char.lowercase()[0].code - 97] += 1
        }
    }

    var odds = 0
    for (occurrences in chars) {
        if (occurrences % 2 == 0) continue
        else {
            odds++
            if (odds > 1) return false
        }
    }

    return true
}

private fun isPalindromePermutationWithArray2(str: String): Boolean {
    val chars = Array(26) { 0 }
    var odds = 0
    for (char in str) {
        if (char != ' ') {
            chars[char.lowercase()[0].code - 97] += 1
            if (chars[char.lowercase()[0].code - 97] % 2 != 0) {
                odds++
            } else {
                odds--
            }
        }
    }

    return odds <= 1
}

private fun isPalindromePermutationWithBitVector(str: String): Boolean {
    var chars = 0 // bit vector (32 bit)
    for (char in str) {
        if (char == ' ') continue
        val pos = char.lowercase()[0].code - 97
        chars = if (chars and 1.shl(pos) == 0) {
            chars or 1.shl(pos)
        } else {
            chars and (1.shl(pos).inv())
        }
    }

    var occurrences = 0
    for (i in 0..25) {
        if (chars and 1.shl(i) > 0) occurrences++
        if (occurrences > 1) return false
    }

    return true
}