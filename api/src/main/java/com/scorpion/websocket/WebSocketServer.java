package com.scorpion.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author scorpion
 * @date 2022/2/13
 */
@Component
/*
* 前端请求路径，相当于requestMapping
* */
@ServerEndpoint("/webSocket/{oid}")
public class WebSocketServer {
    private static ConcurrentHashMap<String,Session> sessionMaps=new ConcurrentHashMap<>();

    /*
    * 前端发送请求建立websocket连接，就会执行onOpen方法
    * */
    @OnOpen
    public void open(@PathParam("oid") String orderId, Session session){
    //  每当打开支付页面，就会生成一个session对象，存入concurrentHashMap中
        sessionMaps.put(orderId, session);
    }

    /*
    *前端关闭页面或者主动关闭websocket连接，就会执行close方法
    * */
    @OnClose
    public void close(@PathParam("oid") String orderId){
    //  移除session对象
    sessionMaps.remove(orderId);
    }

    /**
     * 通过websocket向前端发送信息
     * @param orderId
     * @param msg
     */
    public static void sendMsg(String orderId, String msg){
        try {
            Session session = sessionMaps.get(orderId);
            session.getBasicRemote().sendText(msg);
        }catch(Exception e){
            e.printStackTrace();
        }
    }




}
