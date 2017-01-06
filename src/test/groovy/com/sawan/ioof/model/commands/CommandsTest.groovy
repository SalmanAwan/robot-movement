package com.sawan.ioof.model.commands

import com.sawan.ioof.model.Direction
import com.sawan.ioof.model.Point
import com.sawan.ioof.model.Robot
import com.sawan.ioof.model.terrains.TableTopTerrain
import spock.lang.Specification

class CommandsTest extends Specification {

    static point
    static direction
    static terrain
    static robot

    void setup() {
        point = new Point(2, 2)
        terrain = new TableTopTerrain(5, 5)
        robot = new Robot(terrain)
        direction = Direction.EAST
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
        robot.direction == Direction.EAST
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
        currP           | currD           | newX | newY
        new Point(2, 2) | Direction.EAST  | 2    | 3
        new Point(2, 2) | Direction.WEST  | 2    | 1
        new Point(2, 2) | Direction.NORTH | 3    | 2
        new Point(2, 2) | Direction.SOUTH | 1    | 2
        new Point(4, 4) | Direction.EAST  | 4    | 4
        new Point(0, 0) | Direction.WEST  | 0    | 0
        new Point(4, 4) | Direction.NORTH | 4    | 4
        new Point(0, 0) | Direction.SOUTH | 0    | 0
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
        currD           | newD
        Direction.EAST  | Direction.SOUTH
        Direction.WEST  | Direction.NORTH
        Direction.NORTH | Direction.EAST
        Direction.SOUTH | Direction.WEST
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
        currD           | newD
        Direction.EAST  | Direction.NORTH
        Direction.WEST  | Direction.SOUTH
        Direction.NORTH | Direction.WEST
        Direction.SOUTH | Direction.EAST
    }

}
