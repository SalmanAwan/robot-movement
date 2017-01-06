package com.sawan.ioof.model

import spock.lang.Specification

class RobotTest extends Specification {

    def "Robot construction with terrain"() {
        when:
        def trrain = new TableTopTerrain(5, 5)
        def robot = new Robot(terrain)

        then:
        robot.terrain.width  == 5
        robot.terrain.height == 5
    }

    def "Robot is not positioned untill terrain and inital position is set"() {
        when:
        def robot = new Robot(terrain)

        then:
        !robot.isPositioned()

        where:
        terrain << [null, new TableTopTerrain(5, 5)]
    }

}
