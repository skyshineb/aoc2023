package day5

class Range {
    long source, dest, length

    Range(source, dest, length) {
        this.source = source
        this.dest = dest
        this.length = length
    }

    boolean inside(long n) {
        return n >= source && n < source + length
    }

    long map(long n) {
        return n + (dest - source)
    }
}
