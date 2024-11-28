package com.chatting.controller;

import com.chatting.domain.ChatRoom;
import com.chatting.dto.ChatRoomDto;
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
    public ResponseEntity<List<ChatRoomDto>> room(){
        List<ChatRoomDto> chatRoomDto = chatRoomService.findAllRoom();
        return ResponseEntity.ok(chatRoomDto);
    }

    @PostMapping("/room")
    public ResponseEntity<ChatRoomDto> createRoom(@RequestParam String name) {
        ChatRoomDto chatRoomDto = chatRoomService.createChatRoom(name);
        return ResponseEntity.ok(chatRoomDto);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<ChatRoomDto> findRoom(@PathVariable String roomId){
        ChatRoomDto chatRoomDto = chatRoomService.findChatRoomById(roomId);
        return ResponseEntity.ok(chatRoomDto);
    }

}
