package com.sawan.ioof

import com.sawan.ioof.helper.TestHelper
import spock.lang.Specification

class ApplicationTest extends Specification {

    def "main"() {
        when:
        def app = new Application()
        String [] list = l
        app.main(list)

        then:
        true

        where:
        l << [[TestHelper.COMMANDS_FILE_PATH], [], [null]]
    }
}
