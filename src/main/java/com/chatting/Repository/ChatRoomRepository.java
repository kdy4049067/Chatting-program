package com.chatting.Repository;

import com.chatting.domain.ChatRoom;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChatRoomRepository {

    private Map<String, ChatRoom> chatRoomMap;

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



}
