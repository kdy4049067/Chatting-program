package com.chatting.domain;

import lombok.Data;

import java.util.*;

@Data
public class ChatRoom implements Comparable<ChatRoom>{

    private String roomId;
    private String name;
    private GenerateRandom generateRandom;

    public static ChatRoom create(String name, GenerateRandom generateRandom){
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = generateRandom.generateRandomNumber();
        chatRoom.name = name;

        return chatRoom;
    }

    @Override
    public int compareTo(ChatRoom chatRoom){
        return this.roomId.compareTo(chatRoom.getRoomId());
    }

}

