package org.example

import java.io.File

fun main() {
    val fileName = "src/main/resources/dayFourInput.txt"
    val file = File(fileName)
    val grid = wordSearchHelper(file)
    val count = countWordOccurences(grid)

    println(count)
}

fun wordSearchHelper(input: File): List<List<Char>> {
    val grid = mutableListOf<List<Char>>()
    input.forEachLine { line ->
        if(line.isNotBlank()) {
            val row = line.trim().toCharArray().toList()
            grid.add(row)
        }
    }
    return grid
}

fun countWordOccurences(grid: List<List<Char>>): Int {
    if(grid.isEmpty() || grid[0].isEmpty()) return 0
    val numRows = grid.size
    val numCols = grid[0].size
    var count = 0

    val validSequences = listOf("MAS", "SAM")


    for (row in 1 until numRows - 1) {
        for (col in 1 until numCols - 1) {
            val centerChar = grid[row][col].uppercaseChar()
            if(centerChar != 'A') continue

            val diag1 = "" + grid[row - 1][col - 1] + centerChar + grid[row + 1][col + 1]
            val diag2 = "" + grid[row -1][col +1 ] + centerChar + grid[row + 1][col - 1]

            if(validSequences.contains(diag1) && validSequences.contains(diag2)) {
                count++
            }
        }
    }
    return count
}