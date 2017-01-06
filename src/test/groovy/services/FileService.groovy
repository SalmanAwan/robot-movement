package services

import spock.lang.Specification

class FileService extends Specification {

    def COMMANDS_FILE_PATH = 'src/test/resources/commands.txt'

    def "FileService read file lines"() {
        when:
        def service = new FileService(COMMANDS_FILE_PATH)
        def lines = service.getLines();

        then:
        File commandsFile = new File(COMMANDS_FILE_PATH)
        assert(commandsFile.exists())

        def rows = file.readLines()
        assert rows.size() == 3

        assert lines.size() == rows.size()
    }

}
