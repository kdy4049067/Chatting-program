package com.chatting.domain;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GenerateRandomRoom implements GenerateRandom{

    @Override
    public String generateRandomNumber(){
        return UUID.randomUUID().toString();
    }

}
