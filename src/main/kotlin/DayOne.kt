package org.example

import java.io.File

fun main() {
    val fileName = "src/main/resources/dayOneInput.txt"
    val input = File(fileName).readLines()

    val (firstNumbers, secondNumbers) = parseNumber(input)
    val totalDistance = calculateTotalDistance(firstNumbers, secondNumbers)
    val total = compareNumbers(firstNumbers, secondNumbers)
    println("First numbers: $firstNumbers")
    println("Second numbers: $secondNumbers")
    println("Distance: $totalDistance")
    println("Total: $total")
}


fun parseNumber(input: List<String>): Pair<List<Int>, List<Int>> {
    val firstNumbers = mutableListOf<Int>()
    val secondNumbers = mutableListOf<Int>()

    input.forEach { line ->
        val numbers = line.trim().split("\\s+".toRegex()).filter { it.isNotEmpty() }
        if (numbers.size >= 2) {
            val num1 = numbers[0].toInt()
            val num2 = numbers[1].toInt()

            if (num1 != num2) {
                firstNumbers.add(num1)
                secondNumbers.add(num2)
            }
        } else {
            println("Line doesn't contain $line")
        }
    }

    return Pair(firstNumbers, secondNumbers)
}

fun compareNumbers(numbers1: List<Int>, numbers2: List<Int>): Int {
    val total = numbers1.sumOf { num ->
        numbers2.count { it == num } * num
    }

    return total
}


fun calculateTotalDistance(firstNumbers: List<Int>, secondNumbers: List<Int>): Int {
    val sortedFirstNumbers = firstNumbers.sorted()
    val sortedSecondNumbers = secondNumbers.sorted()

    return sortedFirstNumbers.mapIndexed { index, num1 ->
        val num2 = sortedSecondNumbers[index]
        kotlin.math.abs(num1 - num2)
    }.sum()
}