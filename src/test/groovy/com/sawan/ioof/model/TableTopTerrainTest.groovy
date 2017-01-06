package com.sawan.ioof.model

import spock.lang.Specification

class TableTopTerrainTest extends Specification {

    def "Terrain construction"() {
        when:
        def terrain = new TableTopTerrain(x, y)

        then:
        terrain.x == x
        terrain.y == y

        where:
        x    | y
        null | null
        0    | 0
        5    | 5
        5000 | 500
     }

    def "Terrain point within bounds"() {
        when:
        def terrain = new TableTopTerrain(5, 5)

        then:
        terrain.inBounds(x, y)

        where:
        x | y
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
        !terrain.inBounds(x, y)

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
