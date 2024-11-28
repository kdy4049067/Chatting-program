package com.chatting.service;

import com.chatting.Repository.ChatRoomRepository;
import com.chatting.domain.ChatRoom;
import com.chatting.dto.ChatRoomDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoomDto> findAllRoom(){
        return chatRoomRepository.findAll().stream()
                .map(ChatRoom::createChatRoomDto)
                .toList();
    }

    public ChatRoomDto findChatRoomByName(String name){
        ChatRoom chatRoom = chatRoomRepository.findByName(name);
        return chatRoom.createChatRoomDto();
    }

    public ChatRoomDto findChatRoomById(String id){
        ChatRoom chatRoom = chatRoomRepository.findByName(id);
        return chatRoom.createChatRoomDto();
    }

    public void createChatRoom(String name){
        ChatRoom chatRoom = new ChatRoom(name);
        chatRoomRepository.save(chatRoom);
    }

}
