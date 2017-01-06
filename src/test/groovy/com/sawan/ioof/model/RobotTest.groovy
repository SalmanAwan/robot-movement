package com.sawan.ioof.model

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class RobotTest extends Specification {

    @Shared static Terrain terrain
    @Shared static Point point

    void setup() {
        terrain = new TableTopTerrain(5, 5)
        point = new Point(-1, -1)
    }

    def "Robot construction with terrain"() {
        when:
        def robot = new Robot(terrain)

        then:
        robot.curr == null
        robot.facing == null
        robot.terrain.width  == 5
        robot.terrain.height == 5
    }

    @Unroll
    def "Robot is not positioned untill terrain is set and properly placed on it"() {
        when:
        def robot = new Robot(t)
        robot.place(p, d)

        then:
        !robot.isPlaced()

        where:
        t << [null, terrain]
        p << [null, point]
        d << [null, Direction.EAST]
    }

}
