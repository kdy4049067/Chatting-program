package com.chatting.domain;

import lombok.Data;

import java.util.*;

@Data
public class ChatRoom implements Comparable<ChatRoom>{

    private String roomId;
    private String name;
    private GenerateRandom generateRandom;

    public ChatRoom(String name, GenerateRandom generateRandom){
        this.generateRandom = generateRandom;
        this.name = name;
        this.roomId = generateRandom.generateRandom();
    }

    @Override
    public int compareTo(ChatRoom chatRoom){
        return this.roomId.compareTo(chatRoom.getRoomId());
    }

}

