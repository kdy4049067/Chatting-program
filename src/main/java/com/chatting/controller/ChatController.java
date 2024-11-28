package com.chatting.controller;

import com.chatting.ChattingApplication;
import com.chatting.Repository.ChatRoomRepository;
import com.chatting.domain.ChatMessage;
import com.chatting.domain.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatRoomRepository chatRoomRepository;

    public ChatController(SimpMessageSendingOperations messagingTemplate, ChatRoomRepository chatRoomRepository){
        this.messagingTemplate = messagingTemplate;
        this.chatRoomRepository = chatRoomRepository;
    }

   @MessageMapping("/chat/send")
   public void sendMessage(ChatMessage chatMessage){
        messagingTemplate.convertAndSend("/sub/chat/room/" + chatMessage.getRoomId(), chatMessage);
   }

}
