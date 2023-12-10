import org.junit.jupiter.api.Test

class Day1Test {
    def input = "1abc2\n" +
            "pqr3stu8vwx\n" +
            "a1b2c3d4e5f\n" +
            "treb7uchet"

    def input2 = "two1nine\n" +
            "eightwothree\n" +
            "abcone2threexyz\n" +
            "xtwone3four\n" +
            "4nineeightseven2\n" +
            "zoneight234\n" +
            "7pqrstsixteen"

    def input3 = "oneight"
    @Test
    void partialInput(){
        def solver = new Day1()
        assert solver.solve(input) == 142
        assert solver.solve(input2) == 281
        assert solver.solve(input3) == 18
    }

    @Test
    void fullInput(){
        def solver = new Day1()
        def input = new File(getClass().getResource("day1/input.txt").toURI()).text
        println(solver.solve(input))
    }

}
