package com.chatting.controller;

import com.chatting.domain.ChatRoom;
import com.chatting.service.ChatRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        return ResponseEntity.ok(chatRoom);
    }

    @PostMapping("/room")
    public ResponseEntity<ChatRoom> createRoom(@RequestParam String name) {
        ChatRoom chatRoom = chatRoomService.createRoom(name);
        return ResponseEntity.ok(chatRoom);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<ChatRoom> findRoom(@PathVariable String roomId){
        ChatRoom chatRoom = chatRoomService.findRoomById(roomId);
        return ResponseEntity.ok(chatRoom);
    }

}
