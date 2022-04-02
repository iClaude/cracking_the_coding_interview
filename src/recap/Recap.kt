package recap

fun main() {
    val n = 6
    val matrix = Array(n) { i ->
        Array(n) { j ->
            i * n + j + 1
        }
    }
    println("start")
    rotateMatrix(matrix)
    println("end")
}

private fun rotateMatrix(matrix: Array<Array<Int>>) {
    if (matrix.size <= 1 || matrix.size != matrix[0].size) return

    val lastIndex = matrix.lastIndex
    for (i in 0 until matrix.size / 2) {
        for (j in i until lastIndex - i) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[lastIndex - j][i]
            matrix[lastIndex - j][i] = matrix[lastIndex - i][lastIndex - j]
            matrix[lastIndex - i][lastIndex - j] = matrix[j][lastIndex - i]
            matrix[j][lastIndex - i] = tmp
        }
    }
}