package chapter01

/*  Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place? */

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