package com.chatting.service;

import com.chatting.Repository.ChatRoomRepository;
import com.chatting.domain.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public ChatRoomService(ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository = chatRoomRepository;
    }

    public List<ChatRoom> findAllRoom(){
        return chatRoomRepository.allRoom();
    }

    public ChatRoom findRoomById(String id){
        return chatRoomRepository.findChatRoomById(id);
    }

    public ChatRoom createRoom(String name){
        return chatRoomRepository.createChatRoom(name);
    }

    public void deleteRoom(String id){
        chatRoomRepository.deleteChatRoom(id);
    }

}
