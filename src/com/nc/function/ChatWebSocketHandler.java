package com.nc.function;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler{
    
    private final static List<WebSocketSession> sessions = Collections.synchronizedList(new ArrayList<WebSocketSession>());
    //�����ı���Ϣ�������ͳ�ȥ
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
       try {
			
           super.handleTextMessage(session, message);
           for(int i = 0;i < sessions.size();i++)
           {
        	  sessions.get(i).sendMessage(message);
           }
         }
          catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
          }
    }
    //���ӽ�������
    @SuppressWarnings("unchecked")
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("connect to the websocket chat success......");
        sessions.add(session);
        //����������Ϣ
    }
    //�׳��쳣ʱ����
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        try {
            if(session.isOpen()){

				session.close();
			}
        }catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
        	
			}
        System.out.println("websocket chat error, connection closed......");
        sessions.remove(session);
    }
    //���ӹرպ���
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("websocket chat connection closed......");
        sessions.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
