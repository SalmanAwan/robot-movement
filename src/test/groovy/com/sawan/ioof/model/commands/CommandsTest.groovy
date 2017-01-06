package com.sawan.ioof.model.commands

import com.sawan.ioof.model.Point
import com.sawan.ioof.model.Robot
import com.sawan.ioof.model.terrains.TableTopTerrain
import spock.lang.Specification

import static com.sawan.ioof.model.Direction.*

class CommandsTest extends Specification {

    static point
    static direction
    static terrain
    static robot

    void setup() {
        point = new Point(2, 2)
        terrain = new TableTopTerrain(5, 5)
        robot = new Robot(terrain)
        direction = EAST
    }

    def "PlaceRobotCommand execute"() {
        when:
        def pc = new PlaceRobotCommand(point, direction)
        pc.execute(robot)

        then:
        robot.terrain.height == 5
        robot.terrain.width  == 5
        robot.point.x == 2
        robot.point.y == 2
        robot.direction == EAST
    }

    def "MoveRobotCommand execute"() {
        setup:
        robot.point     = currP
        robot.direction = currD

        when:
        def mc = new MoveRobotCommand()
        mc.execute(robot)

        then:
        robot.point.x   == newX
        robot.point.y   == newY
        robot.direction == currD

        where:
        currP           | currD | newX | newY
        new Point(2, 2) | EAST  | 3    | 2
        new Point(2, 2) | WEST  | 1    | 2
        new Point(2, 2) | NORTH | 2    | 3
        new Point(2, 2) | SOUTH | 2    | 1
        new Point(4, 4) | EAST  | 4    | 4
        new Point(0, 0) | WEST  | 0    | 0
        new Point(4, 4) | NORTH | 4    | 4
        new Point(0, 0) | SOUTH | 0    | 0
    }

    def "RightRobotCommand execute"() {
        setup:
        robot.point     = point
        robot.direction = currD

        when:
        def mc = new RightRobotCommand()
        mc.execute(robot)

        then:
        robot.direction == newD

        where:
        currD | newD
        EAST  | SOUTH
        WEST  | NORTH
        NORTH | EAST
        SOUTH | WEST
    }

    def "LefttRobotCommand execute"() {
        setup:
        robot.point     = point
        robot.direction = currD

        when:
        def mc = new LeftRobotCommand()
        mc.execute(robot)

        then:
        robot.direction == newD

        where:
        currD | newD
        EAST  | NORTH
        WEST  | SOUTH
        NORTH | WEST
        SOUTH | EAST
    }

    def "ReportRobotCommand execute"() {
        setup:
        robot.point     = point
        robot.direction = direction

        when:
        def mc = new ReportRobotCommand()
        mc.execute(robot)

        then:
        robot.toString() == '2,2,EAST'

    }
}
