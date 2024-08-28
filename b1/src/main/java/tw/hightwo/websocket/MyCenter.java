package tw.hightwo.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

import hightwo.tw.apis.WSClient;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/mycenter")
public class MyCenter {
	private static HashSet<Session> sessions;
	private static HashMap<String,WSClient> users;
	private static boolean hasClient1;
	
	public MyCenter() {
		if (sessions == null) {
			sessions = new HashSet<Session>();
			users = new HashMap<String,WSClient>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("OnOpen");
		if (sessions.add(session)) {
			WSClient user = new WSClient();
			user.setSession(session);
			users.put(session.getId(), user);
			System.out.println("Count:" + sessions.size());
		}
	}

	@OnMessage
	public void onMessage(String mesg, Session session) {
		System.out.println("onMessage:" + mesg);
		JSONObject root = new JSONObject(mesg);
		if (root.getBoolean("isInit")) {
			if (root.getBoolean("isClient1")) {
				if(!hasClient1) {
					users.get(session.getId()).setClient1(true);
					System.out.println("isClient1");
				}
				else {
					users.remove(session.getId());
					sessions.remove(session);
				}
			}else {
				users.get(session.getId()).setClient1(false);
				System.out.println("isClient2");
			}
		}else {
			System.out.println("drawing...");
			// 要繪圖
			JSONObject sendMesg = new JSONObject();
			if (root.getBoolean("isClear")) {
				sendMesg.put("isClear", true);
				System.out.println("clear");
			}else {
				sendMesg.put("isClear", false);
				sendMesg.put("isNewLine", root.getBoolean("isNewLine"));
				sendMesg.put("x", root.getInt("x"));
				sendMesg.put("y", root.getInt("y"));
				System.out.println(root.getBoolean("isNewLine")?"newline":"drawline");
			}
			
			//廣播出去
			System.out.println("===>" + sendMesg.toString());
			Set<String> ids = users.keySet();
			for (String id : ids) {
				if (!users.get(id).isClient1()) {
					try {
						users.get(id).getSession().getBasicRemote().sendText(sendMesg.toString());
					} catch (IOException e) {
					}
				}
			}
		}
		
	}
	
	@OnClose
	public void onClose(Session session) {
		users.remove(session.getId());
		sessions.remove(session);
		System.out.println("onClose:" + sessions.size());
		
	}
	
	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError:" + t.toString());
		
	}
	
	
	
}
