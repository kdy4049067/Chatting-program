package com.chatting.Repository;

import com.chatting.domain.ChatRoom;
import com.chatting.domain.GenerateRandom;
import com.chatting.domain.GenerateRandomRoom;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRoomMap;
    private final GenerateRandom generateRandom;

    public ChatRoomRepository(GenerateRandom generateRandom){
        this.generateRandom = generateRandom;
    }

    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoom> allRoom(){
        List<ChatRoom> chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.sort(chatRooms);

        return chatRooms;
    }

    public ChatRoom findChatRoomById(String id){
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(String name){
        ChatRoom chatRoom = ChatRoom.create(name, generateRandom);
        chatRoomMap.put(chatRoom.getRoomId(), chatRoom);
        return chatRoom;
    }

    public void deleteChatRoom(String id){
        chatRoomMap.remove(id);
    }

}
