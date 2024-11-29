package com.chatting.domain;

import com.chatting.dto.ChatRoomDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.*;

@Data
@NoArgsConstructor
@Entity(name="chatting")
public class ChatRoom implements Comparable<ChatRoom>{
    @Id
    private String roomId;
    @Column
    private String name;

    @PrePersist
    public void generateId(){
        if(this.roomId == null){
            this.roomId = UUID.randomUUID().toString();
        }
    }

    public ChatRoom(String name){
        this.name = name;
    }

    @Override
    public int compareTo(ChatRoom chatRoom){
        return this.roomId.compareTo(chatRoom.getRoomId());
    }

    public ChatRoomDto createChatRoomDto(){
        return new ChatRoomDto(
                this.roomId,
                this.name
        );
    }

}

