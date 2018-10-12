package com.divae.celebritystockexchange.spec

import com.divae.celebritystockexchange.page.CelebrityDetailPage
import geb.spock.GebReportingSpec

class CelebrityDetailSpec extends GebReportingSpec {

    def "Celebrety name should be displayed"() {
        when:
        to CelebrityDetailPage
        then:
        at CelebrityDetailPage
        headingBox.size() > 0
    }
}
