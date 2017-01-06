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
        point = new Point(2, 4)
        terrain = new TableTopTerrain(5, 5)
        robot = new Robot(terrain)
        direction = Direction.EAST
    }

    def "PlaceRobotCommand execute"() {
        when:
        def c = new PlaceRobotCommand(point, direction)
        c.execute(robot)

        then:
        robot.terrain.height == 5
        robot.terrain.width  == 5
        robot.point.x == 2
        robot.point.y == 4
        robot.direction == Direction.EAST
    }

}
