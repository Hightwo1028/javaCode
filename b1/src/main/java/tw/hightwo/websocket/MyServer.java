package tw.hightwo.websocket;

import java.util.HashMap;
import java.util.HashSet;

import org.apache.catalina.ant.SessionsTask;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	
	public MyServer() {
		System.out.println("MyServer");
		if(sessions == null) {
			sessions = new HashSet<Session>();
			users = new HashMap<String, Session>();
		}
	}
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("OnOpen");
		if(sessions.add(session)) {
			users.put(session.getId(), session); //唯一ID 字串
			System.out.println("Count" + sessions.size());
		}
	}
	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("OnMessage" + mesg);
		
		for(Session user : sessions) {
			try {
				user.getBasicRemote().sendText(mesg);
			} catch (Exception e) {
				System.out.println(user.getBasicRemote());
			}
		}
	}
	@OnClose
	public void onClose(Session session) {
		System.out.println("OnClose");
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("onClose:" + sessions.size());
	}
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("OnError" + t.toString());
		
	}
}
