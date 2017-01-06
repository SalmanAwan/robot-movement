package com.sawan.ioof.services

import com.sawan.ioof.commands.Command
import com.sawan.ioof.helper.TestHelper
import spock.lang.Specification

import static com.sawan.ioof.helper.TestHelper.COMMANDS_FILE_PATH

class CommandsServiceTest extends Specification {

    def "CommandsService generate commands"() {
        when:
        def service = new CommandsService(COMMANDS_FILE_PATH)
        def commands = service.getCommands();

        then:
        def lines = TestHelper.readRawRows()
        commands.size() == lines.size()
        commands.count { it instanceof PlaceCommand  } == lines.count { it.matches Command.PLACE_REGEX  }
        commands.count { it instanceof MoveCommand   } == lines.count { it.matches Command.MOVE_REGEX   }
        commands.count { it instanceof LeftCommand   } == lines.count { it.matches Command.LEFT_REGEX   }
        commands.count { it instanceof RightCommand  } == lines.count { it.matches Command.RIGHT_REGEX  }
        commands.count { it instanceof ReportCommand } == lines.count { it.matches Command.REPORT_REGEX }
    }

    def "CommandsService no commands"() {
        when:
        def service = new CommandsService('foo')
        def commands = service.getCommands();

        then:
        commands.size() == 0
    }
}
