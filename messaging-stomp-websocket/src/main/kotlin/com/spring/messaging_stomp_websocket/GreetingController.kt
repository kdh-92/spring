package com.spring.messaging_stomp_websocket

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greeting(helloMessage: HelloMessage): Greeting {
        return Greeting("Hello, ${helloMessage.name}!")
    }
}
