package com.spring.messaging_stomp_websocket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greeting(HelloMessage: HelloMessage): Greeting {
        return Greeting("Hello, ${HelloMessage.name}!")
    }
}