class Day3 {
    static long getNums(String s, int pos, boolean[][] bitmap, int bitmapRow) {
        if (s[pos].isNumber() && !bitmap[bitmapRow][pos]) {
            def (startI, endI) = [pos, pos]
            while (startI > 0 && s[startI - 1].isNumber()) {
               startI--
            }
            while (endI < s.length() - 1 && s[endI + 1].isNumber()) {
                endI++
            }
            for (i in startI..endI) {
                bitmap[bitmapRow][i] = true
            }
            return Long.parseLong(s[startI..endI])
        }
        0
    }

    static long part1(String s) {
        def sumList = new ArrayList<Long>()
        def array = s.replace('.', ' ').split("\n")
        def bitmap = new boolean[array.length][array[0].length()]
        for (i in 0..<array.length) {
            def line = array[i]
            for (j in 0..<line.length()) {
                def c = line[j]
                if (!c.isBlank() && !c.isNumber()) {
                    // found special, lets grab adj numbers
                    def (onLeftBoundary, onRightBoundary) = [j == 0, j == line.length() - 1]
                    def (onTopBoundary, onBottomBoundary) = [i == 0, i == array.length - 1]
                    // top row
                    if (!onTopBoundary) {
                        if (!onLeftBoundary) {
                            sumList.push(getNums(array[i - 1], j - 1, bitmap, i - 1))
                        }
                        sumList.push(getNums(array[i - 1], j, bitmap, i - 1))
                        if (!onRightBoundary) {
                            sumList.push(getNums(array[i - 1], j + 1, bitmap, i - 1))
                        }
                    }
                    // right and left
                    if (!onLeftBoundary) {
                        sumList.push(getNums(line, j - 1, bitmap, i))
                    }
                    if (!onRightBoundary) {
                        sumList.push(getNums(line, j + 1, bitmap, i))
                    }
                    // bottom row
                    if (!onBottomBoundary) {
                        if (!onLeftBoundary) {
                            sumList.push(getNums(array[i + 1], j - 1, bitmap, i + 1))
                        }
                        sumList.push(getNums(array[i + 1], j, bitmap, i + 1))
                        if (!onRightBoundary) {
                            sumList.push(getNums(array[i + 1], j + 1, bitmap, i + 1))
                        }
                    }
                }
            }
        }
        sumList.sum(0)
    }

    static long part2(String s) {
        def sumList = new ArrayList<Long>()
        def array = s.replace('.', ' ').split("\n")
        def bitmap = new boolean[array.length][array[0].length()]
        for (i in 0..<array.length) {
            def line = array[i]
            for (j in 0..<line.length()) {
                def c = line[j]
                if (c == '*') {
                    def adjList = new ArrayList<Long>()
                    // found special, lets count adj numbers
                    def (onLeftBoundary, onRightBoundary) = [j == 0, j == line.length() - 1]
                    def (onTopBoundary, onBottomBoundary) = [i == 0, i == array.length - 1]
                    // top row
                    if (!onTopBoundary) {
                        if (!onLeftBoundary) {
                            adjList.push(getNums(array[i - 1], j - 1, bitmap, i - 1))
                        }
                        adjList.push(getNums(array[i - 1], j, bitmap, i - 1))
                        if (!onRightBoundary) {
                            adjList.push(getNums(array[i - 1], j + 1, bitmap, i - 1))
                        }
                    }
                    // right and left
                    if (!onLeftBoundary) {
                        adjList.push(getNums(line, j - 1, bitmap, i))
                    }
                    if (!onRightBoundary) {
                        adjList.push(getNums(line, j + 1, bitmap, i))
                    }
                    // bottom row
                    if (!onBottomBoundary) {
                        if (!onLeftBoundary) {
                            adjList.push(getNums(array[i + 1], j - 1, bitmap, i + 1))
                        }
                        adjList.push(getNums(array[i + 1], j, bitmap, i + 1))
                        if (!onRightBoundary) {
                            adjList.push(getNums(array[i + 1], j + 1, bitmap, i + 1))
                        }
                    }
                    if (adjList.findAll {it != 0}.size() == 2) {
                        sumList.add(adjList.findAll { it != 0 }.inject(1) {acc, val -> acc * val})
                    }
                }
            }
        }
        sumList.sum(0)
    }
}
