package com.chatting.domain;

import java.util.UUID;

public class GenerateRandomRoom implements GenerateRandom{

    @Override
    public String generateRandomNumber(){
        return UUID.randomUUID().toString();
    }

}
