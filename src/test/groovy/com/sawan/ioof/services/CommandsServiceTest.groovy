package com.sawan.ioof.services

import com.sawan.ioof.helper.TestHelper
import spock.lang.Specification

import static com.sawan.ioof.helper.TestHelper.COMMANDS_FILE_PATH

class CommandsServiceTest extends Specification {

    def "CommandsService generate commands"() {
        when:
        def service = new CommandsService(COMMANDS_FILE_PATH)
        def commands = service.getCommands();

        then:
        commands.size() == TestHelper.readRawRows().size()
    }

    def "CommandsService no commands"() {
        when:
        def service = new CommandsService('foo')
        def commands = service.getCommands();

        then:
        commands.size() == 0
    }
}
