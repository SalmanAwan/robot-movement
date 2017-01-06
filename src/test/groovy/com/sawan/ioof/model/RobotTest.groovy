package com.sawan.ioof.model

import com.sawan.ioof.model.terrains.TableTopTerrain
import com.sawan.ioof.model.terrains.Terrain
import spock.lang.Specification
import spock.lang.Unroll

import static com.sawan.ioof.model.Direction.EAST

class RobotTest extends Specification {

    static Terrain terrain
    static Point point
    static Point pointVoid
    static Point pointXVoid
    static Point pointYVoid

    void setup() {
        terrain      = new TableTopTerrain(5, 5)
        point        = new Point(0, 0)
        pointVoid    = new Point(Point.VOID, Point.VOID)
        pointXVoid   = new Point(Point.VOID, 0)
        pointYVoid   = new Point(0, Point.VOID)
    }

    def "Robot construction with terrain"() {
        when:
        def r = new Robot(terrain)

        then:
        r.point == null
        r.direction == null
        r.terrain.width  == 5
        r.terrain.height == 5
    }

    @Unroll
    def "Robot not isPlaced when no terrain"() {
        when:
        def r = robot

        then:
        !r.isPlaced()

        where:
        robot << [new Robot(null), new Robot(terrain)]
    }

    @Unroll
    def "Robot not isPlaced when no valid point or direction"() {
        when:
        def r = new Robot(terrain)
        r.point = p
        r.direction = d

        then:
        !r.isPlaced()

        where:
        p          | d
        null       | EAST
        point      | null
        pointVoid  | EAST
        pointXVoid | EAST
        pointYVoid | EAST
    }

    @Unroll
    def "Robot place throws"() {
        when:
        def r = new Robot(terrain)
        r.place(p, d)

        then:
        thrown(java.lang.IllegalArgumentException.class)

        where:
        p          | d
        null       | null
        null       | EAST
        point      | null
        pointVoid  | EAST
        pointXVoid | EAST
        pointYVoid | EAST
    }

    def "Robot isPlaced"() {
        when:
        def r = new Robot(terrain)
        r.place(point, EAST)

        then:
        r.isPlaced()
    }

    def "Robot move not placed"() {
        when:
        def r = new Robot(terrain)
        r.move()

        then: true
    }

    def "Robot turnRight not placed"() {
        when:
        def r = new Robot(terrain)
        r.turnRight()

        then: true
    }

    def "Robot turnLeft not placed"() {
        when:
        def r = new Robot(terrain)
        r.turnLeft()

        then: true
    }

    def "Robot report not placed"() {
        when:
        def r = new Robot(terrain)
        r.report()

        then: true
    }
}
