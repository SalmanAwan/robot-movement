package com.sawan.ioof.model

import spock.lang.Specification

import static com.sawan.ioof.model.Direction.*

class DirectionTest extends Specification {

    def "Direction valueOf"() {
        when:
        def d = Direction.valueOf(str)

        then:
        d.equals(result)

        where:
        str    | result
        'EAST' | EAST
        'WEST' | WEST
        'NORTH'| NORTH
        'SOUTH'| SOUTH
    }

    def "Direction values"() {
        when:
        def vs = Direction.values()

        then:
        vs == [EAST, WEST, NORTH, SOUTH]
    }

    def "Direction getRightOf"() {
        when:
        def d = Direction.getRightOf(curr)

        then:
        d == result

        where:
        curr  | result
        EAST  | SOUTH
        WEST  | NORTH
        NORTH | EAST
        SOUTH | WEST
    }

    def "Direction getLeftOf"() {
        when:
        def d = Direction.getLeftOf(curr)

        then:
        d == result

        where:
        curr  | result
        EAST  | NORTH
        WEST  | SOUTH
        NORTH | WEST
        SOUTH | EAST
    }

}
