package com.sawan.ioof.services

import com.sawan.ioof.commands.*
import com.sawan.ioof.helper.TestHelper
import spock.lang.Specification

import static com.sawan.ioof.helper.TestHelper.COMMANDS_FILE_PATH

class CommandsServiceTest extends Specification {

    def "CommandsService generate commands"() {
        when:
        def service = new CommandsService(COMMANDS_FILE_PATH)
        def commands = service.getRobotCommands();

        then:
        def lines = TestHelper.readRawRows()
        commands.size() == 13 // valid commands
        commands.count { it instanceof PlaceRobotCommand  } == lines.count { it.matches RobotCommand.PLACE_REGEX  }
        commands.count { it instanceof MoveRobotCommand   } == lines.count { it.matches RobotCommand.MOVE_REGEX   }
        commands.count { it instanceof LeftRobotCommand   } == lines.count { it.matches RobotCommand.LEFT_REGEX   }
        commands.count { it instanceof RightRobotCommand  } == lines.count { it.matches RobotCommand.RIGHT_REGEX  }
        commands.count { it instanceof ReportRobotCommand } == lines.count { it.matches RobotCommand.REPORT_REGEX }
    }

    def "CommandsService no commands"() {
        when:
        def service = new CommandsService('foo')
        def commands = service.getRobotCommands();

        then:
        commands.size() == 0
    }
}
