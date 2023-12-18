class Day4 {

    static int part1(String s) {
        s.split("\n").collect {line ->
            def (String numbersStr, String bingoStr) = line.split(":")[1].trim().split("[|]")
            def bingoSet = bingoStr.trim().split(" +").collect {Integer.parseInt(it.trim())}.toSet()
            def wins = numbersStr.trim().split(" +").collect { Integer.parseInt(it.trim()) }
                    .count { bingoSet.contains(it) }
            wins == 0 ? 0 : 1 * 2 ** (wins - 1)
        }.inject(0) {acc, val -> acc + val}
    }
}
