package com.chatting.service;

import com.chatting.Repository.ChatRepository;
import com.chatting.Repository.ChatRoomRepository;
import com.chatting.domain.ChatMessage;
import com.chatting.domain.ChatRoom;
import com.chatting.dto.ChatDto;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public ChatService(final ChatRepository chatRepository){
        this.chatRepository = chatRepository;
    }

    public ChatDto createChat(ChatMessage.MessageType messageType, String message, String sender, ChatRoom chatRoom){
        ChatMessage chatMessage = new ChatMessage(messageType, message, sender, chatRoom);
        chatRepository.save(chatMessage);

        return ChatDto.toChatDto(chatMessage);
    }

}
