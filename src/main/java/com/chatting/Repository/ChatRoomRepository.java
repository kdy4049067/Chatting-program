package com.chatting.Repository;

import com.chatting.domain.ChatRoom;
import com.chatting.domain.GenerateRandom;
import com.chatting.domain.GenerateRandomRoom;
import com.chatting.exception.ErrorException;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

    public ChatRoom findByName(String name);

    public ChatRoom findByRoomId(String id);

    public List<ChatRoom> findAll();

}
