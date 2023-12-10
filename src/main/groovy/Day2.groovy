class Day2 {

    def limits = [
            "red" : 12,
            "green": 13,
            "blue": 14
    ]

    int part1(String s) {
        def res = 0
        s.lines().forEach {
            def key = Integer.parseInt(it.split(":")[0].split(" ")[1])
            def illegalGame = false
            def draws = it.split(":")[1].trim().split(";")
            for (draw in draws) {
                def noIllegalGames = draw.split(",").toList().findAll{color ->
                def cnt = color.trim().split(" ")[0]
                def clr = color.trim().split(" ")[1]
                Integer.parseInt(cnt) > limits[clr]
                }.isEmpty()
                if (!noIllegalGames) {
                   illegalGame = true
                    break
                }
            }
            if (!illegalGame) {
                res += key
            }
        }
        return res
    }

    int part2(String s) {
        return s.lines().mapToInt {
            def (maxRed, maxGreen, maxBlue) = [0, 0, 0]
            def draws = it.split(":")[1].trim().split(";")
            for (draw in draws) {
                draw.split(",").toList().forEach{color ->
                    def cnt = color.trim().split(" ")[0]
                    def clr = color.trim().split(" ")[1]
                    switch (clr) {
                        case "green" -> maxGreen = Math.max(maxGreen, Integer.parseInt(cnt))
                        case "blue" -> maxBlue = Math.max(maxBlue, Integer.parseInt(cnt))
                        case "red" -> maxRed = Math.max(maxRed, Integer.parseInt(cnt))
                    }
                }
            }
            maxGreen * maxBlue * maxRed
        }.sum()
    }
}
