package com.chatting.exception;

import lombok.Getter;

@Getter
public class Exception {

    private static final String findError = "찾는 id가 존재하지 않습니다.";
    private static final String duplicateError = "이미 채팅방 id가 존재합니다.";

}
