import day2.Day2
import org.junit.jupiter.api.Test

class Day2Test {
    def input = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green\n" +
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue\n" +
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red\n" +
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red\n" +
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"

    @Test
    void part1Partial(){
        def solver = new Day2()
        assert solver.part1(input) == 8
    }

    @Test
    void part2Partial(){
        def solver = new Day2()
        assert solver.part2(input) == 2286
    }

    @Test
    void part1Full(){
        def solver = new Day2()
        def input = new File(getClass().getResource("day2/input.txt").toURI()).text
        def expected = 2563
        def actual = solver.part1(input)
        assert actual == expected
        println(actual)
    }

    @Test
    void part2Full(){
        def solver = new Day2()
        def input = new File(getClass().getResource("day2/input.txt").toURI()).text
        def expected = 70768
        def actual = solver.part2(input)
        assert actual == expected
        println(actual)
    }

}
