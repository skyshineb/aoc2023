package day6

class Day6 {

    static List<Long> getValuesPart1(String s) {
        s.split(" ")[1..-1].findAll {!it.isBlank()}.collect {Long.parseLong(it)}
    }

    static long getValuesPart2(String s) {
        s.split(" ")[1..-1].findAll {!it.isBlank()}.inject("") {acc, val -> acc.concat(val)}.toLong()
    }

    static long part1(String s) {
        List<Long> limits = getValuesPart1(s.split("\n")[0])
        List<Long> records = getValuesPart1(s.split("\n")[1])
        int[] potentialBeatsPerGame = new int[limits.size()]

        for (i in 0..<limits.size()) {
            def holdTime = 1
            def beats = 0
            while (holdTime < limits[i] - 1) {
                def dist = (limits[i] - holdTime) * holdTime
                if (dist > records[i]) {
                    beats ++
                }
                holdTime += 1
            }
            potentialBeatsPerGame[i] = beats
        }
        potentialBeatsPerGame.inject(1) { acc, val -> acc * val} as long
    }

    static long part2(String s) {
        def limit = getValuesPart2(s.split("\n")[0])
        def record = getValuesPart2(s.split("\n")[1])
        int potentialBeatsPerGame = 0

        def holdTime = 1
        def beats = 0
        while (holdTime < limit - 1) {
            def dist = (limit - holdTime) * holdTime
            if (dist > record) {
                beats ++
            }
            holdTime += 1
        }
        beats
    }
}
