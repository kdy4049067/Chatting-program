package com.chatting.domain;

import com.chatting.dto.ChatRoomDto;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Controller;

import java.util.*;

@Data
@Entity(name="chatting")
public class ChatRoom implements Comparable<ChatRoom>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String roomId;
    @Column
    private String name;

    public ChatRoom createChatRoom(String chatRoomName){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.name = chatRoomName;
        return chatRoom;
    }

    @Override
    public int compareTo(ChatRoom chatRoom){
        return this.roomId.compareTo(chatRoom.getRoomId());
    }

    public ChatRoomDto createChatRoomDto(ChatRoom chatRoom){
        return new ChatRoomDto(
                chatRoom.roomId,
                chatRoom.name
        );
    }

}

