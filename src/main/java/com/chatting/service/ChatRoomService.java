package com.chatting.service;

import com.chatting.Repository.ChatRoomRepository;
import com.chatting.domain.ChatMessage;
import com.chatting.domain.ChatRoom;
import com.chatting.dto.ChatRoomDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository = chatRoomRepository;
    }

    @Transactional
    public List<ChatRoomDto> findAllRoom(){
        return chatRoomRepository.findAll().stream()
                .map(ChatRoom::createChatRoomDto)
                .toList();
    }

    @Transactional
    public ChatRoomDto findChatRoomByName(String name){
        ChatRoom chatRoom = chatRoomRepository.findByName(name);
        return chatRoom.createChatRoomDto();
    }

    @Transactional
    public ChatRoomDto findChatRoomById(String id){
        ChatRoom chatRoom = chatRoomRepository.findByRoomId(id);
        return chatRoom.createChatRoomDto();
    }

    @Transactional
    public ChatRoomDto createChatRoom(String name){
        ChatRoom chatRoom = new ChatRoom(name);
        chatRoomRepository.save(chatRoom);

        return chatRoom.createChatRoomDto();
    }

    @Transactional
    public List<ChatMessage> findAllChatMessage(){
        return chatRoomRepository.findAllChatMessage();
    }

    @Transactional
    public ChatRoom findByRoomId(String roomId){
        ChatRoom chatRoom = chatRoomRepository.findByRoomId(roomId);
        if(chatRoom == null)
            throw new IllegalArgumentException("chatRoom 없음");

        return chatRoom;
    }

    @Transactional
    public List<ChatMessage> findChatByRoomId(String roomId){
        List<ChatMessage> allChat = findAllChatMessage();
         return allChat.stream()
                .filter(chatMessage -> chatMessage.getRoomId().equals(roomId))
                .collect(Collectors.toList());
    }

}
