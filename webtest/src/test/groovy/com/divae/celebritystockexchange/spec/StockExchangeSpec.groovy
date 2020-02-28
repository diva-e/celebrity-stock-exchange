package com.divae.celebritystockexchange.spec

import com.divae.celebritystockexchange.page.CelebrityDetailPage
import geb.spock.GebReportingSpec

class StockExchangeSpec extends GebReportingSpec {

    def "Page has title"() {
        when:
        to CelebrityDetailPage
        then:
        title == "StockExchange"
    }
}
