package org.example

import java.io.File

fun main() {
    val fileName = "src/main/resources/dayTwoInput.txt"


    try {
        val reports = readReportsFromFile(fileName)

        val safeReportsCount = reports.count { isReportsSafe(it) }

        val safeReportsWithDampener = reports.count { isReportsSafeWithDampener(it) }

        println("Number of reports $safeReportsCount")
        println("Number of reports with dampener $safeReportsWithDampener")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }
}

fun readReportsFromFile(fileName: String): List<List<Int>> {
    val reports = mutableListOf<MutableList<Int>>()

    File(fileName).forEachLine {
        val levels = it.trim().split("\\s+".toRegex()).mapNotNull { it.toIntOrNull() }
        if (levels.isNotEmpty()) {
            reports.add(levels.toMutableList())
        }
    }

    return reports
}

fun isReportsSafeWithDampener(levels: List<Int>): Boolean {
    if (isReportsSafe(levels)) {
        return true
    }

    for (i in levels.indices) {
        val modifiedLevels = levels.toMutableList()
        modifiedLevels.removeAt(i)
        if(isReportsSafe(modifiedLevels)) {
            return true
        }
    }

    return false
}

fun isReportsSafe(levels: List<Int>): Boolean {
    if (levels.size < 2) {
        return true
    }

    val firstDifference = levels[1] - levels[0]

    if (firstDifference == 0) {
        return false
    }

    val isIncreasing = firstDifference > 0
    val isDecreasing = firstDifference < 0

    for (i in 1 until levels.size) {
        val diff = levels[i] - levels[i - 1]
        if (diff == 0 || kotlin.math.abs(diff) > 3) {
            return false
        }

        if (isIncreasing && diff <= 0) {
            return false
        }

        if (isDecreasing && diff >= 0) {
            return false
        }
    }

    return true
}