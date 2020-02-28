package com.divae.celebritystockexchange.spec

import com.divae.celebritystockexchange.page.ErrorPage
import geb.spock.GebReportingSpec

class ErrorSpec extends GebReportingSpec {

    def "Error page has error picture"() {
        when:
        to ErrorPage
        then:
        $("p").has("img")
    }
}
