package com.sawan.ioof.model

import spock.lang.Specification

class TableTopTerrainTest extends Specification {

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

    def "Terrain point within bounds"() {
        when:
        def terrain = new TableTopTerrain(5, 5)

        then:
        terrain.isWithinBounds(i, j)

        where:
        i | j
        0 | 0
        0 | 4
        2 | 2
        4 | 0
        4 | 4
    }

    def "Terrain point out of bounds"() {
        when:
        def terrain = new TableTopTerrain(5, 5)

        then:
        !terrain.isWithinBounds(i, j)

        where:
        i  | j
        -1 | -1
        -1 | 0
        0  | -1
        5  | 0
        0  | 5
        5  | 5
    }

}
