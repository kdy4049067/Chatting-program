package com.chatting.controller;

import com.chatting.ChattingApplication;
import com.chatting.Repository.ChatRoomRepository;
import com.chatting.domain.ChatMessage;
import com.chatting.domain.ChatRoom;
import com.chatting.dto.ChatDto;
import com.chatting.service.ChatRoomService;
import com.chatting.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;
    private final ChatService chatService;
    private final ChatRoomService chatRoomService;

    public ChatController(SimpMessageSendingOperations messagingTemplate, ChatService chatService, ChatRoomService chatRoomService){
        this.messagingTemplate = messagingTemplate;
        this.chatService = chatService;
        this.chatRoomService = chatRoomService;
    }

   @MessageMapping("/chat/send")
   public void sendMessage(ChatDto chatDto){
        messagingTemplate.convertAndSend("/sub/chat/room/" + chatDto.roomId(), chatDto);
   }

   @PostMapping("/chat/save")
    public ResponseEntity<ChatDto> saveMessage(@RequestBody ChatDto chatDto){
        ChatRoom chatRoom = chatRoomService.findByRoomId(chatDto.roomId());
        ChatDto chatDto1 = chatService.createChat(chatDto.messageType(), chatDto.message(), chatDto.sender(), chatRoom);

        return ResponseEntity.ok(chatDto1);
   }

}
