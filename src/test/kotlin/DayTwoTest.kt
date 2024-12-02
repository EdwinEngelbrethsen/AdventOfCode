import org.example.isReportsSafe
import org.example.isReportsSafeWithDampener
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DayTwoTest {
    @Test
    fun testSafeReportIncreasing() {
        val levels = listOf(1, 2, 3, 4, 5)
        assertTrue(isReportsSafe(levels))
    }

    @Test
    fun testSafeReportDecreasing() {
        val levels = listOf(5, 4, 3, 2, 1)
        assertTrue(isReportsSafe(levels))
    }

    @Test
    fun testUnsafeReportDueToDirectionChange() {
        val levels = listOf(1, 2, 3, 2, 1)
        assertFalse(isReportsSafe(levels))
    }

    @Test
    fun testUnsafeReportDueToLargeDifference() {
        val levels = listOf(1, 2, 6, 7, 8)
        assertFalse(isReportsSafe(levels))
    }

    @Test
    fun testUnsafeReportDueToZeroDifference() {
        val levels = listOf(1, 1, 2, 3, 4)
        assertFalse(isReportsSafe(levels))
    }

    @Test
    fun testSafeReportWithDampener_RemovalMakesSafe() {
        val levels = listOf(1, 3, 2, 4, 5)
        assertTrue(isReportsSafeWithDampener(levels))
    }

    @Test
    fun testUnsafeReportEvenWithDampener() {
        val levels = listOf(1, 2, 7, 8, 9)
        assertFalse(isReportsSafeWithDampener(levels))
    }

    @Test
    fun testSingleLevelReport() {
        val levels = listOf(5)
        assertTrue(isReportsSafe(levels))
    }

    @Test
    fun testTwoLevelSafeReport() {
        val levels = listOf(1, 3)
        assertTrue(isReportsSafe(levels))
    }

    @Test
    fun testTwoLevelUnsafeReport_LargeDifference() {
        val levels = listOf(1, 5)
        assertFalse(isReportsSafe(levels))
    }

    @Test
    fun testReportWithIdenticalLevels() {
        val levels = listOf(2, 2, 2, 2)
        assertFalse(isReportsSafe(levels))
    }

    @Test
    fun testSafeReportWithDampener_RemovingIdenticalLevel() {
        val levels = listOf(3, 3, 4, 5)
        assertTrue(isReportsSafeWithDampener(levels))
    }

    @Test
    fun testReportWithNegativeLevels_Increasing() {
        val levels = listOf(-5, -4, -3, -2, -1)
        assertTrue(isReportsSafe(levels))
    }

    @Test
    fun testReportWithNegativeLevels_Decreasing() {
        val levels = listOf(-1, -2, -3, -4, -5)
        assertTrue(isReportsSafe(levels))
    }

    @Test
    fun testReportWithNegativeLevels_Unsafe() {
        val levels = listOf(-1, -2, -1, -2, -3)
        assertFalse(isReportsSafe(levels))
    }

    @Test
    fun testEmptyReport() {
        val levels = emptyList<Int>()
        assertTrue(isReportsSafe(levels))
    }
}