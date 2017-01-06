package com.sawan.ioof.services

import spock.lang.Specification

class FileServiceTest extends Specification {

    def COMMANDS_FILE_PATH = 'src/test/resources/test-commands.txt'

    def "FileService read file lines"() {
        setup:
        File commandsFile = new File(COMMANDS_FILE_PATH)
        assert(commandsFile.exists())

        def rows = commandsFile.readLines()
        assert rows.size() == 12

        when:
        def service = new FileService(COMMANDS_FILE_PATH)
        def lines = service.getLines();

        then:
        assert lines.size() == rows.size()
    }

}
