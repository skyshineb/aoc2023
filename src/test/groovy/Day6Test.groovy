import day6.Day6
import org.junit.jupiter.api.Test

class Day6Test {
    final String input = """Time:      7  15   30
Distance:  9  40  200"""

    @Test
    void testPart1Partial() {
        assert Day6.part1(input) == 288
    }

    @Test
    void testPart1Full() {
        def data = getClass().getResource("day6/input.txt").text
        println(Day6.part1(data))
    }

    @Test
    void testPart2Partial() {
        assert Day6.part2(input) == 71503
    }

    @Test
    void testPart2Full() {
        def data = getClass().getResource("day6/input.txt").text
        println(Day6.part2(data))
    }
}
