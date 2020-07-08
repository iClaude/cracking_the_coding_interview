package chapter01

/* PROBLEM
   1.6 Given an image represented by an NxN matrix, where each pixel in the image is 4
   bytes, write a method to rotate the image by 90 degrees. Can you do this in place? */


/* ALGORITHM
   Rotation in place.
   We rotate the matrix starting from the outer ring, the considering the inner rings one
   after the other.
   For each ring we take each element of the top side, put it in the final position in the
   right side, take the relative element and put in the final position in the bottom side,
   take the relative element and put it in the final position in the left side.
   We just need to be very careful to calculate the correct indices. */

fun main() {
    val n = 3
    val matrix = Array(n) { i ->
        Array(n) { j ->
            i * n + (j + 1)
        }
    }

    println("original matrix")
    printMatrix(matrix)
    println("matrix rotated 90 degrees")
    rotateMatrix90(matrix)
    printMatrix(matrix)
}

private fun printMatrix(matrix: Array<Array<Int>>) {
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            print("${matrix[i][j]}  ")
        }
        println()
    }
}

private fun rotateMatrix90(matrix: Array<Array<Int>>) {
    for (level in 0..(matrix.size - 1) / 2) {
        for (i in level..(matrix.size - 2 - level)) {
            val el1 = matrix[level][i]
            val el2 = matrix[i][matrix.size - 1 - level]
            val el3 = matrix[matrix.size - 1 - level][matrix.size - 1 - i]
            val el4 = matrix[matrix.size - 1 - i][level]
            matrix[level][i] = el4
            matrix[i][matrix.size - 1 - level] = el1
            matrix[matrix.size - 1 - level][matrix.size - 1 - i] = el2
            matrix[matrix.size - 1 - i][level] = el3
        }

    }
}