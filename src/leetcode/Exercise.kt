package leetcode

fun main() {
    val matrix = Array(3) { row ->
        Array(4) { column ->
            5
        }
    }
    matrix[0][1] = 0

    println("original matrix:")
    printMatrix(matrix)

    zeroMatrix(matrix)
    println("zeroed matrix:")
    printMatrix(matrix)
}

private fun zeroMatrix(matrix: Array<Array<Int>>) {
    val rowsToZero = Array(matrix.size) { false }
    val colsToZero = Array(matrix[0].size) { false }

    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            if (matrix[row][col] == 0) {
                rowsToZero[row] = true
                colsToZero[col] = true
            }
        }
    }
    for (row in matrix.indices) {
        for (col in matrix[row].indices) {
            if (rowsToZero[row] || colsToZero[col]) {
                matrix[row][col] = 0
            }
        }
    }
}

private fun printMatrix(matrix: Array<Array<Int>>) {
    for (row in matrix.indices) {
        for (column in matrix[row].indices) {
            print("${matrix[row][column]}  ")
        }
        println()
    }
}
