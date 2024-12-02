import org.example.calculateTotalDistance
import org.example.parseNumber
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals


class DayOneTest {

    @Test
    fun testParseNumbers() {
        val lines = listOf(
            "1 3",
            "2 3",
            "3 3",
            "3 4",
            "3 5",
            "4 9"
        )

        val (firstNumbers, secondNumbers) = parseNumber(lines)

        // Exclude the pair where num1 == num2
        assertContentEquals(listOf(1, 2, 3, 3, 4), firstNumbers)
        assertContentEquals(listOf(3, 3, 4, 5, 9), secondNumbers)
    }

    @Test
    fun testCalculateDistance() {
        val firstNumbers = listOf(1, 2, 3, 3, 3, 4)
        val secondNumbers = listOf(3, 3, 3, 4, 5, 9)

        val totalDistance = calculateTotalDistance(firstNumbers, secondNumbers)

        assertEquals(11, totalDistance)
    }
}