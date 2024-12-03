package org.example

import java.io.File

fun main() {
    val fileName = "src/main/resources/dayThreeInput.txt"

    try {
        val corruptedInput = File(fileName).readText()

        val totalSumDoDont = calculateMultiplicationInstructionSum(corruptedInput)

        println("Total sum with do's and don't: $totalSumDoDont")
    } catch (e: Exception) {
        println(e.message)
    }

}

fun calculateMultiplicationInstructionSum(corruptedInput: String): Int {
    val regex = Regex("""mul\((\d{1,3}),(\d{1,3})\)|do\(\)|don't\(\)""")

    var totalSumDoDont = 0
    var multiplication = true

    val matches = regex.findAll(corruptedInput)

    for (match in matches) {
        val instructions = match.value

        when {
            instructions == "do()" -> {
                multiplication = true
                println("Multiplication: $multiplication")
            }

            instructions == "don't()" -> {
                multiplication = false
                println("Multiplication: $multiplication")
            }

            instructions.startsWith("mul(") && multiplication -> {
                val multiplicationRegex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")
                val multiplicationMatch = multiplicationRegex.matchEntire(instructions)
                if (multiplicationMatch != null) {
                    val num1 = multiplicationMatch.groupValues[1].toInt()
                    val num2 = multiplicationMatch.groupValues[2].toInt()
                    val product = num1 * num2
                    totalSumDoDont += product
                    println("product: $product")
                }
            }
        }
    }
    return totalSumDoDont
}