package com.spring.messaging_stomp_websocket

import com.fasterxml.jackson.annotation.JsonSetter

data class HelloMessage(
    private var _name: String? = null
) {
    var name: String
        get() = _name?.ifEmpty { "anonymous" }.toString()

        @JsonSetter
        set(value) {
            _name = value
        }
}
