package com.chatting.dto;

import com.chatting.domain.ChatMessage;
import com.chatting.domain.ChatRoom;

public record ChatDto(ChatMessage.MessageType messageType, String message, String sender, String roomId) {

    public static ChatDto toChatDto(ChatMessage chatMessage){
        return new ChatDto(
                chatMessage.getMessageType(),
                chatMessage.getMessage(),
                chatMessage.getSender(),
                chatMessage.getChatRoom().getRoomId()
        );
    }

}
