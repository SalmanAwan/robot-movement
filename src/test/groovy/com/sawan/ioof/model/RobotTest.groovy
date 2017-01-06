package com.sawan.ioof.model

import spock.lang.Specification
import spock.lang.Unroll

class RobotTest extends Specification {

    static Terrain terrain
    static Point point
    static Point pointInvalid
    static Robot robot

    void setup() {
        terrain      = new TableTopTerrain(5, 5)
        point        = new Point(0, 0)
        pointInvalid = new Point(Point.VOID, Point.VOID)
        robot        = new Robot(terrain)
    }

    def "Robot construction with terrain"() {
        when:
        def r = robot

        then:
        r.curr == null
        r.facing == null
        r.terrain.width  == 5
        r.terrain.height == 5
    }

    @Unroll
    def "Robot is not positioned untill terrain is set and properly placed on it"() {
        when:
        def r = robot

        then:
        !r.isPlaced()

        where:
        r << [new Robot(null), new Robot(terrain)]
    }

    @Unroll
    def "Robot throws when attempt to place incorrectly"() {
        when:
        r

        then:
        thrown(IllegalArgumentException.class)

        where:
        r << [robot.place(point, null),
              robot.place(pointInvalid, Direction.EAST)]
    }
}
