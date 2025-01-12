package com.chatting.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ChatMessage")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ChatMessage {

    public ChatMessage(MessageType messageType, String message, String sender, ChatRoom chatRoom){
        this.messageType = messageType;
        this.message = message;
        this.sender = sender;
        this.chatRoom = chatRoom;
    }

    public enum MessageType{
        ENTER, TALK, EXIT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int messageId;
    @Column
    private MessageType messageType;
    @Column
    private String message;
    @Column
    private String sender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roomId")
    private ChatRoom chatRoom;

}
