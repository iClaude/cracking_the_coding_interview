package leetcode

fun main() {
    val myArray = intArrayOf(1, 2, 2, 3, 1)
    println("shortest subarray length = ${findShortestSubarray(myArray)}")
}

fun findShortestSubarray(arr: IntArray): Int {
    val occurrencesMap: MutableMap<Int, OccurrencesData> = mutableMapOf()
    for (i in arr.indices) {
        val occurrenceData = occurrencesMap[arr[i]] ?: OccurrencesData()
        occurrenceData.apply {
            occurrences++
            if (ind1 == -1) {
                ind1 = i
                ind2 = i
            }
            if (i > ind2) ind2 = i
        }
        occurrencesMap[arr[i]] = occurrenceData
    }

    var maxOcc = Integer.MIN_VALUE
    var minLen = Integer.MAX_VALUE
    for ((_, occurrenceData) in occurrencesMap) {
        if (occurrenceData.occurrences >= maxOcc) {
            minLen = if (occurrenceData.occurrences > maxOcc) Integer.MAX_VALUE else minLen
            maxOcc = occurrenceData.occurrences
            val len = occurrenceData.ind2 - occurrenceData.ind1 + 1
            if (len < minLen) {
                minLen = len
            }
        }
    }

    return minLen
}

class OccurrencesData(
        var occurrences: Int = 0,
        var ind1: Int = -1,
        var ind2: Int = -1
)