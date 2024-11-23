package com.chatting.domain;

import lombok.Data;

@Data
public class ChatMessage {

    public enum MessageType{
        ENTER, TALK, EXIT
    }

    private MessageType messageType;
    private String message;
    private String sender;
    private String roomId;

}
