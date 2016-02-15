package no.bareshop.server;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.socket.WebSocketMessage;

/**
 * Created by kubilay on 15.02.2016.
 */
public class WSMessageImpl implements WebSocketMessage<String> {
    String t;


    public WSMessageImpl(String text){
        this.t=text;
    }

    @Override
    public String getPayload() {

        return t;
    }

    @Override
    public int getPayloadLength() {
        return 0;
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
