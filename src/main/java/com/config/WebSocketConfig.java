package com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@Configuration
@EnableWebSocketMessageBroker //STOMP 프로토콜을 기반으로 한 메시지 브로커를 활성화, 클라이언트 사이에서 메시지를 라우팅하는 역할을 함.
                              //webSocket 메시징을 간단하게 설정할 수 있음

public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        config.enableSimpleBroker("/sub"); //sub로 시작하는 경로에 대한 메시지를 브로커가 처리하도록 설정, 메시지 브로커의 prefix 등록
        config.setApplicationDestinationPrefixes("/pub"); // 클라이언트가 메시지를 보낼 때 사용하는 경로를 정의. /pub/hello로 메시지를 보내면 서버의 핸들러가 처리함,  도착 경로에 대한 prefix
    }

}
