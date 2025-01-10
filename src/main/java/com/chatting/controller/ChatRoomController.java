package com.chatting.controller;

import com.chatting.domain.ChatRoom;
import com.chatting.dto.ChatRoomDto;
import com.chatting.service.ChatRoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@Tag(name = "채팅방 API", description = "컨트룰러에 대한 설명입니다.")
@RequestMapping("/chat")
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    public ChatRoomController(ChatRoomService chatRoomService){
        this.chatRoomService = chatRoomService;
    }

    @Operation(summary = "채팅방 조회", description = "모든 채팅방 조회")
    @GetMapping("/rooms")
    public ResponseEntity<List<ChatRoomDto>> room(){
        List<ChatRoomDto> chatRoomDto = chatRoomService.findAllRoom();
        return ResponseEntity.ok(chatRoomDto);
    }

    @Operation(summary = "채팅방 생성", description = "입력받은 name 의 채팅방 생성")
    @Parameter(name = "chattingRoomName", description = "채팅방 이름")
    @PostMapping("/room")
    public ResponseEntity<ChatRoomDto> createRoom(@RequestBody Map<String, String> requestBody) {
        String name = requestBody.get("name");
        ChatRoomDto chatRoomDto = chatRoomService.createChatRoom(name);
        return ResponseEntity.ok(chatRoomDto);
    }

    @Operation(summary = "채팅방 조회", description = "파라미터를 통한 채팅방 조회")
    @Parameter(name = "chattingRoomId", description = "찾고자 하는 채팅방 ID")
    @GetMapping("/room/findById/{roomId}")
    public ResponseEntity<ChatRoomDto> findRoom(@PathVariable (name = "roomId") String roomId){
        ChatRoomDto chatRoomDto = chatRoomService.findChatRoomById(roomId);
        return ResponseEntity.ok(chatRoomDto);
    }

    @Operation(summary = "채팅방 조회", description = "파라미터를 통한 채팅방 조회")
    @Parameter(name = "chattingRoomName", description = "찾고자 하는 채팅방 name")
    @GetMapping("/room/findByName/{roomName}")
    public ResponseEntity<ChatRoomDto> findRoomByName(@PathVariable (name = "roomName") String roomName){
        ChatRoomDto chatRoomDto = chatRoomService.findChatRoomByName(roomName);
        return ResponseEntity.ok(chatRoomDto);
    }

}
