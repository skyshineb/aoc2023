import day5.Day5
import day5.Range
import day5.Transform
import org.junit.jupiter.api.Test

class Day5Test {
    final def input = """seeds: 79 14 55 13

seed-to-soil map:
50 98 2
52 50 48

soil-to-fertilizer map:
0 15 37
37 52 2
39 0 15

fertilizer-to-water map:
49 53 8
0 11 42
42 0 7
57 7 4

water-to-light map:
88 18 7
18 25 70

light-to-temperature map:
45 77 23
81 45 19
68 64 13

temperature-to-humidity map:
0 69 1
1 0 69

humidity-to-location map:
60 56 37
56 93 4"""

    @Test
    void rangeTests() {
        def r1 = new Range(0, 5, 5)
        assert r1.inside(0)
        assert r1.inside(4)
        assert !r1.inside(5)
        assert !r1.inside(-1)
        assert r1.map(0) == 5
        assert r1.map(4) == 9
    }

    @Test
    void transformTest() {
        def t1 = new Transform()
        t1.addRange([98, 50, 2] as Range)
        t1.addRange([50, 52, 48] as Range)
        assert t1.map(98) == 50
        assert t1.map(99) == 51
        assert t1.map(50) == 52
        assert t1.map(97) == 99
        assert t1.inside(97)
        assert t1.inside(98)
        assert !t1.inside(100)
    }

    @Test
    void part1Part() {
        assert Day5.part1(input) == 35
    }

    @Test
    void part1Full() {
        def data = new File(getClass().getResource("day5/input.txt").toURI()).text
        println(Day5.part1(data))
    }

    @Test
    void part2Full() {
        def data = new File(getClass().getResource("day5/input.txt").toURI()).text
        println(Day5.part2(data))
    }
}
