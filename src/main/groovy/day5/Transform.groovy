package day5

class Transform {
    final List<Range> ranges

    Transform() {
        ranges = new ArrayList<>()
    }

    boolean inside(long n) {
        return ranges.any {range -> range.inside(n)}
    }

    long map(long n) {
        if (inside(n)) {
            ranges.find {r -> r.inside(n)}.map(n)
        } else {
            n
        }
    }

    void addRange(Range range) {
        ranges.add(range)
    }
}
