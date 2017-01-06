package com.sawan.ioof.model

import spock.lang.Specification

class PointTest extends Specification {

    def "Point default state"() {
        when:
        def p = new Point()

        then:
        p.x == Point.VOID
        p.y == Point.VOID
    }

    def "Point toString"() {
        when:
        def str = new Point(0, 0).toString()

        then:
        str.equals('0 0')
    }

}
