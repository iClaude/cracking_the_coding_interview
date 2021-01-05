package leetcode

fun main() {

}

class Solution {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val rows = Array(mat.size) {
            Row(it, mat[0].size)
        }

        mat.forEachIndexed { index, arr ->
            for (i in arr.indices) {
                if (arr[i] == 0) break
                rows[index].weakness--
            }
        }

        val result = Array(k) { -1 }
        rows.sortDescending()
        for (i in 0 until k) {
            result[i] = rows[i].index
        }

        return result.toIntArray()
    }
}

data class Row(val index: Int, var weakness: Int) : Comparable<Row> {
    override fun compareTo(other: Row): Int {
        if (this.weakness != other.weakness) return this.weakness - other.weakness
        return other.index - this.index
    }
}