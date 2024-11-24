package com.chatting.controller;

import com.chatting.domain.ChatRoom;
import com.chatting.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static javax.security.auth.callback.ConfirmationCallback.OK;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService){
        this.chatRoomService = chatRoomService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<ChatRoom>> room(){
        List<ChatRoom> chatRoom = chatRoomService.findAllRoom();
        return ResponseEntity.status(OK).body(chatRoom);
    }

    @PostMapping("/room")
    public ResponseEntity<ChatRoom> createRoom(@RequestParam String name) {
        ChatRoom chatRoom = chatRoomService.createRoom(name);
        return ResponseEntity.status(OK).body(chatRoom);
    }

}
