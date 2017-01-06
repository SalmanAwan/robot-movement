package com.sawan.ioof.model

import spock.lang.Specification

class RobotTest extends Specification {

    static Terrain terrain
    static Point point
    static Point pointInvalid

    void setup() {
        terrain      = new TableTopTerrain(5, 5)
        point        = new Point(0, 0)
        pointInvalid = new Point(Point.VOID, Point.VOID)
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

    def "Robot is not positioned untill terrain is set and properly placed on it"() {
        when:
        def robot = r

        then:
        !robot.isPlaced()

        where:
        r << [new Robot(null), new Robot(terrain)]
    }

}
