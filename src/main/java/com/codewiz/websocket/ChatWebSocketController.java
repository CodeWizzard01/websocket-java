package com.codewiz.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

//This is not needed when using pure  WebSocket without STOMP
@Controller
public class ChatWebSocketController {

    private final SimpMessagingTemplate template;

    public ChatWebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String handleTextMessage(String message) {
        return message;
    }

}
