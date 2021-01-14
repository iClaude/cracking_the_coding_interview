package chapter01

/* PROBLEM
   Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column
   is set to 0.

   Solution 1
   Scan the entire matrix and save in two lists the indexes of rows and columns to reset. Then
   take each row and column from the two arrays and reset it.
   This way some elements are considered multiple times, but if the matrix is very big and the rows
   and columns to reset are few, the algorithm is faster than scanning the entire matrix a second
   time.

   Solution 2
   Scan the entire matrix and find the rows and columns to reset, saving the indexes in two arrays
   whose elements are false if the row/column must not be reset and true if they must be reset (the two
   arrays have length equal to the number of rows/columns in the original matrix).
   Then scan the entire matrix again and reset each element according to the informations stored
   in the two arrays (reset if one of the 2 arrays stores true, not reset otherwise).
   This way each element is considered only one time, but you have to scan the matrix 2 times. This
   algorithm is more efficient if the matrix is not very big or the number of rows/columns to reset
   are many.
*/

fun main() {
    val matrix = Array(5) { Array(6) { 1 } }
    matrix[1][0] = 0
    matrix[2][4] = 0
    setMatrixToZero(matrix)

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print(matrix[i][j])
            print(" ")
        }
        println()
    }
}

private fun setMatrixToZero(matrix: Array<Array<Int>>) {
    val colsToReset = mutableListOf<Int>()
    val rowsToReset = mutableListOf<Int>()
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                rowsToReset.add(i)
                colsToReset.add(j)
            }
        }
    }

    for (rowToReset in rowsToReset) {
        for (j in matrix[rowToReset].indices) {
            matrix[rowToReset][j] = 0
        }
    }

    for (colToReset in colsToReset) {
        for (i in matrix.indices) {
            matrix[i][colToReset] = 0
        }
    }

}

private fun setMatrixToZero2(matrix: Array<Array<Int>>) {
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