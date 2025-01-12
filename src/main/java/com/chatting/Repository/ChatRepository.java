package com.chatting.Repository;

import com.chatting.domain.ChatMessage;
import com.chatting.domain.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatMessage, Integer> {
}
