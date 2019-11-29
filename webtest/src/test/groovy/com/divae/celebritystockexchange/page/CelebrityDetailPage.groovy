package com.divae.celebritystockexchange.page

import geb.Page

class CelebrityDetailPage extends Page {
    //static url = "/celebrity/chuck-norris"

    static at = { title == "StockExchange" }

    static content = {
        headingBox {
            $("h1", text: "Chuck Norris")
        }
    }
}

