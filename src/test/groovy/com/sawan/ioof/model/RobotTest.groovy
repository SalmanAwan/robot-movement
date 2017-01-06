package com.sawan.ioof.model

import com.sawan.ioof.model.terrains.TableTopTerrain
import com.sawan.ioof.model.terrains.Terrain
import spock.lang.Specification
import spock.lang.Unroll

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

    def "Robot not isPlaced when no valid point or direction"() {
        when:
        def r = new Robot(terrain)
        r.point = p
        r.direction = d

        then:
        !r.isPlaced()

        where:
        p          | d
        null       | Direction.EAST
        point      | null
        pointVoid  | Direction.EAST
        pointXVoid | Direction.EAST
        pointYVoid | Direction.EAST
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
        null       | Direction.EAST
        point      | null
        pointVoid  | Direction.EAST
        pointXVoid | Direction.EAST
        pointYVoid | Direction.EAST
    }

    def "Robot isPlaced"() {
        when:
        def r = new Robot(terrain)
        r.place(point, Direction.EAST)

        then:
        r.isPlaced()
    }
}
