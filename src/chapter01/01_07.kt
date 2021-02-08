package chapter01

/*  Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees. Can you do this in place? */


fun main() {
    val n = 3
    val matrix = Array(n, { i ->
        Array(n, { j -> i * n + j + 1 })
    })
    println("Original matrix:")
    printMatrix(matrix)

    rotateMatrix(matrix)
    println("\n\nRotated matrix:")
    printMatrix(matrix)
}

private fun rotateMatrix(matrix: Array<Array<Int>>) {
    val n = matrix.size
    for (i in 0 until n / 2) {
        for (j in i..n - 2 - i) {
            val tmp = matrix[i][j]
            matrix[i][j] = matrix[n - 1 - j][i]
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
            matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
            matrix[j][n - 1 - i] = tmp
        }
    }
}

private fun printMatrix(matrix: Array<Array<Int>>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]} ")
        }
        println()
    }
}