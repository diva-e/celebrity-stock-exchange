package com.divae.celebritystockexchange.spec

import com.divae.celebritystockexchange.page.CelebrityDetailPage
import geb.spock.GebReportingSpec
import geb.Browser

class CelebrityDetailSpec extends GebReportingSpec {

    def "Celebrity name should be displayed"() {
        when:
        go "celebrity/chuck-norris"
        then:
        title == "StockExchange"
    }

    def "Celebrity has details"(){
        when:
        go "celebrity/chuck-norris"
        then:



        $("div").has("ul")
        $("ul").has("li")
    }

    def "Celebrity has a picture"(){
        when:
        go "celebrity/chuck-norris"
        then:

        $("div").has("img")
    }

    def "Celebrity has description"(){
        when:
        go "celebrity/chuck-norris"
        then:

        $("div").has("p")
    }

    def "Celebrity details have a header"(){
        when:
        go "celebrity/chuck-norris"
        then:

        $("div").has("h2")
    }
}
