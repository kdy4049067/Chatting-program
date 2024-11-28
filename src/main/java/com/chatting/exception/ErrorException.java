package com.chatting.exception;

public class ErrorException {

    private static final String findError = "찾는 id가 존재하지 않습니다.";
    private static final String duplicateError = "이미 채팅방 id가 존재합니다.";
    private static final String deleteError = "삭제하려는 채팅방 id가 존재하지 않습니다.";

    public static String findError(){
        return findError;
    }

    public static String duplicateError(){
        return duplicateError;
    }

    public static String deleteError(){
        return deleteError;
    }

}
