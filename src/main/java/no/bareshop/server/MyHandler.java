package no.bareshop.server;

import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;


/**
 * Created by kubilay on 15.02.2016.
 */

public class MyHandler extends TextWebSocketHandler implements WebSocketHandler  {



    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        System.out.println(webSocketSession.getId() +"websocket connected");
        String id=webSocketSession.toString();

        //webSocketSession.sendMessage(new WSMessageImpl().setT("hello"));
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println(webSocketSession.getId() + "message" + webSocketMessage.getPayload());
        WebSocketMessage<String> wsmsg=new WSMessageImpl( "hello there");
        webSocketSession.sendMessage(new TextMessage("Yeaaa"));
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.out.println(throwable.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("closed"+closeStatus.toString());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
