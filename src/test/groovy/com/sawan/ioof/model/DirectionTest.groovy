package com.sawan.ioof.model

import spock.lang.Specification

class DirectionTest extends Specification {

    def "Direction valueOf"() {
        when:
        def d = Direction.valueOf(str)

        then:
        d.equals(result)

        where:
        str    | result
        'EAST' | Direction.EAST
        'WEST' | Direction.WEST
        'NORTH'| Direction.NORTH
        'SOUTH'| Direction.SOUTH
    }

    def "Direction values"() {
        when:
        def vs = Direction.values()

        then:
        vs == [Direction.EAST, Direction.WEST, Direction.NORTH, Direction.SOUTH]
    }

}
