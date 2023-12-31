package day5

import groovyx.gpars.GParsPool

import java.util.concurrent.atomic.AtomicLong

class Day5 {

    static final String block1Str = "seed-to-soil map:"
    static final String block2Str = "soil-to-fertilizer map:"
    static final String block3Str = "fertilizer-to-water map:"
    static final String block4Str = "water-to-light map:"
    static final String block5Str = "light-to-temperature map:"
    static final String block6Str = "temperature-to-humidity map:"
    static final String block7Str = "humidity-to-location map:"

    static Transform getTransform(String s) {
        Transform t = new Transform()
        s.split("\n").findAll {!it.isBlank()}
                .collect{range ->
                    def vals = range.split (" ").collect {Long.parseLong(it.trim())}
                    [vals[1], vals[0], vals[2]] as Range
                }
        .forEach {t.addRange(it)}
        t
    }

    static long part1(String s) {
        def end1L = s.indexOf('\n')
        def seeds = s.substring(0, end1L).split(" ")[1..-1].collect {Long.parseLong(it.trim())}
        def block1Start = s.indexOf(block1Str)
        def block2Start = s.indexOf(block2Str)
        def block3Start = s.indexOf(block3Str)
        def block4Start = s.indexOf(block4Str)
        def block5Start = s.indexOf(block5Str)
        def block6Start = s.indexOf(block6Str)
        def block7Start = s.indexOf(block7Str)

        def block1T = getTransform(s.substring(block1Start + block1Str.length() + 1, block2Start))
        def block2T = getTransform(s.substring(block2Start + block2Str.length() + 1, block3Start))
        def block3T = getTransform(s.substring(block3Start + block3Str.length() + 1, block4Start))
        def block4T = getTransform(s.substring(block4Start + block4Str.length() + 1, block5Start))
        def block5T = getTransform(s.substring(block5Start + block5Str.length() + 1, block6Start))
        def block6T = getTransform(s.substring(block6Start + block6Str.length() + 1, block7Start))
        def block7T = getTransform(s.substring(block7Start + block7Str.length() + 1))

        def transformations = [block1T, block2T, block3T, block4T, block5T, block6T, block7T]
        seeds.collect {seed ->
            transformations.inject(seed) {acc, tr -> tr.map(acc)}
        }.min()
    }

    static long part2(String s) {
        def end1L = s.indexOf('\n')
        def seeds = s.substring(0, end1L).split(" ")[1..-1].collect {Long.parseLong(it.trim())}
        def block1Start = s.indexOf(block1Str)
        def block2Start = s.indexOf(block2Str)
        def block3Start = s.indexOf(block3Str)
        def block4Start = s.indexOf(block4Str)
        def block5Start = s.indexOf(block5Str)
        def block6Start = s.indexOf(block6Str)
        def block7Start = s.indexOf(block7Str)

        def block1T = getTransform(s.substring(block1Start + block1Str.length() + 1, block2Start))
        def block2T = getTransform(s.substring(block2Start + block2Str.length() + 1, block3Start))
        def block3T = getTransform(s.substring(block3Start + block3Str.length() + 1, block4Start))
        def block4T = getTransform(s.substring(block4Start + block4Str.length() + 1, block5Start))
        def block5T = getTransform(s.substring(block5Start + block5Str.length() + 1, block6Start))
        def block6T = getTransform(s.substring(block6Start + block6Str.length() + 1, block7Start))
        def block7T = getTransform(s.substring(block7Start + block7Str.length() + 1))

        def transformations = [block1T, block2T, block3T, block4T, block5T, block6T, block7T]
        def minLocation = new AtomicLong(Long.MAX_VALUE)
        GParsPool.withPool(16) {
            seeds.eachWithIndexParallel {val, i ->
                if (i % 2 == 0) {
                    def start = val
                    def length = seeds.get(i + 1)
                    println("seed: ${start} length: ${length} step: ${Math.floorDiv(length, 100)}")
                    def step = Math.floorDiv(length, 100)
                    for (j in start..<start+length) {
                        def res = transformations.inject(j) {acc, tr -> tr.map(acc)}
                        minLocation.getAndAccumulate(res, Math::min)
                        if ((j - start) % step == 0) {
                            println("${System.currentTimeMillis()} ${Thread.currentThread()} step ${(j - start) / step} of 100")
                        }
                    }
                }
            }
        }
        minLocation
    }
}
