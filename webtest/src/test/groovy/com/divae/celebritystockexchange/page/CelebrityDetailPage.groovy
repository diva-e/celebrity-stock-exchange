package com.divae.celebritystockexchange.page

import geb.Page

class CelebrityDetailPage extends Page {
    static url = "/de/referenzen/fc-bayern-muenchen/"

    static at = { title == "FC Bayern München" }

    static content = {
        headingBox {
            $("span", class: "sm-logo-label", text: "FC Bayern München")
        }
    }
}
