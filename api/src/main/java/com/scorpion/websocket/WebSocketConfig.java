package com.scorpion.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;

/**
 * @author scorpion
 * @date 2022/2/13
 */
@Configuration
public class WebSocketConfig {
   /*
    * 添加Websocket服务节点
    * */
    @Bean
    public ServerEndpointExporter getServerEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
