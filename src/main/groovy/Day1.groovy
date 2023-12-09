class Day1 {
    def override = Map.of(
            "one", "o1e",
            "two", "t2o",
            "three", "t3e",
            "four", "f4r",
            "five", "f5e",
            "six", "s6x",
            "seven", "s7n",
            "eight", "e8t",
            "nine", "n9e"
    )
    def pattern = ~"(1)|(2)|(3)|(4)|(5)|(6)|(7)|(8)|(9)"

    int solve(String s) {
        s.lines().mapToInt {
            override.forEach {key, value ->
                it = it.replaceAll(key, value)
            }
            def digits = it.findAll(pattern)[0, -1].collect {
                Integer.parseInt(it)
            }
            return digits[0] * 10 + digits[1]
        }.sum()
    }
}
