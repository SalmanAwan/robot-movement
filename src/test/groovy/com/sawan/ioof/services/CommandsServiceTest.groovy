package com.sawan.ioof.services

import spock.lang.Specification

class CommandsServiceTest extends Specification {

    def "CommandsService generate commands"() {
        when:
        def service = new CommandsService(COMMANDS_FILE_PATH)
        def commands = service.getCommands();

        then:
        commands.size() == 12
    }

    def "CommandsService no commands"() {
        when:
        def service = new CommandsService('foo')
        def commands = service.getCommands();

        then:
        commands.size() == 0
    }
}
