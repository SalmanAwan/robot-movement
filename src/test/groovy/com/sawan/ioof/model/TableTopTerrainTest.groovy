package com.sawan.ioof.model

import spock.lang.Specification
import spock.lang.Unroll

class TableTopTerrainTest extends Specification {

    @Unroll
    def "Terrain construction"() {
        when:
        def terrain = new TableTopTerrain(w, h)

        then:
        terrain.width  == w
        terrain.height == h

        where:
        w    | h
        0    | 0
        5    | 5
        5000 | 500
     }

    @Unroll
    def "Terrain point within bounds"() {
        when:
        def terrain = new TableTopTerrain(5, 5)

        then:
        terrain.isWithinBounds(new Point(x, y))

        where:
        x | y
        0 | 0
        0 | 4
        2 | 2
        4 | 0
        4 | 4
    }

    @Unroll
    def "Terrain point out of bounds"() {
        when:
        def terrain = new TableTopTerrain(5, 5)

        then:
        !terrain.isWithinBounds(new Point(x, y))

        where:
        x  | y
        -1 | -1
        -1 | 0
        0  | -1
        5  | 0
        0  | 5
        5  | 5
    }

}
