import org.junit.jupiter.api.Test

class Day3Test {
    def input = """467..114..
...*......
..35..633.
......#...
617*......
.....+.58.
..592.....
......755.
...\$.*....
.664.598..
"""

    @Test
    void getNumsTest(){
        def bitmap = new boolean[1][10]
        def line = input.replace('.', ' ').split("\n")[0]
        assert Day3.getNums(line, 0, bitmap, 0) == 467
        assert bitmap[0][0..2] == [true, true, true]
        assert Day3.getNums(line, 6, bitmap, 0) == 114
        assert bitmap[0][5..7] == [true, true, true]

        bitmap = new boolean[1][10]
        line = input.replace('.', ' ').split("\n")[2]
        assert Day3.getNums(line, 8, bitmap, 0) == 633
        assert bitmap[0][6..8] == [true, true, true]
    }

    @Test
    void part1Partial(){
        assert Day3.part1(input) == 4361
    }

    @Test
    void part1Full(){
        def data = new File(getClass().getResource("day3/input.txt").toURI()).text
        println(Day3.part1(data))
    }

    @Test
    void part2Partial(){
        assert Day3.part2(input) == 467835
    }

    @Test
    void part2Full(){
        def data = new File(getClass().getResource("day3/input.txt").toURI()).text
        println(Day3.part2(data))
    }

}
