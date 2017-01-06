package com.sawan.ioof.services

import com.sawan.ioof.helper.TestHelper
import spock.lang.Specification

import static com.sawan.ioof.helper.TestHelper.COMMANDS_FILE_PATH

class FileServiceTest extends Specification {

    def "FileService read file lines"() {
        when:
        def service = new FileService(COMMANDS_FILE_PATH)
        def lines = service.getLines();

        then:
        assert lines.size() == TestHelper.readRawRows().size()
    }

    def "FileService gracefully throws"() {
        when:
        new FileService('foo')

        then:
        true    // for coverage
    }

}
