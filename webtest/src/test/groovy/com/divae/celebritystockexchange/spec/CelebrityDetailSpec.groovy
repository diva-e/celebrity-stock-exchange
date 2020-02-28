package com.divae.celebritystockexchange.spec

import com.divae.celebritystockexchange.page.CelebrityDetailPage
import geb.spock.GebReportingSpec
import geb.Browser

class CelebrityDetailSpec extends GebReportingSpec {

    def setupSpec(){
        to CelebrityDetailPage
    }

    def "Celebrity has a picture"(){
        expect:
        $("div").has("img")
    }

    def "Celebrity has header"(){
        expect:
        $("h1").text().length() > 0
    }

    def "Celebrity has description"(){
        expect:
        $("p",0).text().contains("Description:")
    }

    def "Celebrity details have a header"(){
        expect:
        $("div").has("h2")
        $("h2").text().length() > 0
    }

    def "Celebrity has details"(){
        expect:
        def text = $("ul").first().text()

        assert text.contains("ID:")
        assert text.contains("Birthday:")
        assert text.contains("Day of Death:")
        assert text.contains("Job:")
    }
}
