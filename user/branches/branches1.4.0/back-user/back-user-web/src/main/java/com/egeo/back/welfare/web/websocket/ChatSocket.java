package com.egeo.back.welfare.web.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.web.socket.server.standard.SpringConfigurator;

import com.egeo.back.user.business.UserInformationManage;
import com.egeo.basics.user.model.dto.UserInformationDTO;
import com.google.gson.Gson;


@ServerEndpoint(value="/chatSocket",configurator = SpringConfigurator.class)
public class ChatSocket{
	@Resource(name="userInformation")
	private UserInformationManage userInformationManage;
	
	private  static  Set<ChatSocket>  sockets=new HashSet<ChatSocket>();
//	private  static  Map<String, ChatSocket>  sMap=new HashMap<String, ChatSocket>();
	private  static  Map<Long, Session>  map=new HashMap<Long, Session>();
	private  static  List<Long>   userIds=new ArrayList<Long>();
	private  Session  session;
	private Long userId;
	private Gson  gson=new Gson();
	
	@OnOpen
	public  void open(Session  session){
			this.session=session;
			sockets.add(this);
			
			String  queryString = session.getQueryString();
			System.out.println(queryString);
			
			this.userId = Long.valueOf(queryString.substring(queryString.indexOf("=")+1));
			userIds.add(this.userId);
			this.map.put(userId, session);
			TimerTask task = new TimerTask() {
	            public void run() {
	            	UserInformationDTO dto = new UserInformationDTO();
	            	dto.setUserId(userId);
	            	dto.setPlatformId(7L);
	            	int cnt = userInformationManage.cntByUserId(dto);
	    			Session to_session = map.get(userId);
	    			try {
	    				to_session.getBasicRemote().sendText(String.valueOf(cnt));
	    			} catch (IOException e) {
	    				e.printStackTrace();
	    			}
	            	/*int cnt = readInformationManage.cntById(1L);
	    			
	    			broadcast(sockets, String.valueOf(cnt) );*/
	            }  
	        };  
	        Timer timer = new Timer();
	        long delay = 30;
	        long intevalPeriod = 1 * 100;  
	        // schedules the task to be run in an interval  
	        timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	        UserInformationDTO dto = new UserInformationDTO();
        	dto.setUserId(userId);
        	dto.setPlatformId(7L);
        	int cnt = userInformationManage.cntByUserId(dto);
			Session to_session = this.map.get(userId);
			try {
				to_session.getBasicRemote().sendText(String.valueOf(cnt));
			} catch (IOException e) {
				e.printStackTrace();
			}
			/*broadcast(sockets, String.valueOf(cnt) );*/
			
	}
	@OnMessage
	public  void receive(Session  session,String json ){
		UserInformationDTO dto = new UserInformationDTO();
    	dto.setUserId(userId);
    	dto.setPlatformId(7L);
    	int cnt = userInformationManage.cntByUserId(dto);
		broadcast(sockets, String.valueOf(cnt) );
		/*ContentVO vo = gson.fromJson(json, ContentVO.class);
		
		if(vo.getType() == 1){
			//广播
			Message  message=new Message();
			message.setContent(this.username,vo.getMsg());
			
			broadcast(sockets, gson.toJson(message));
		}else{
			//单播
			//根据username 如果能找到对应的session对象
			String to = vo.getTo();
			Session to_session = this.map.get(to);
			
			Message  message=new Message();
			message.setContent(this.username,"<font clolr = red >私聊：" + vo.getMsg() + "</font>");
			
			try {
				to_session.getBasicRemote().sendText(message.toJson());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
	}
	
	@OnClose
	public  void close(Session session){
		sockets.remove(this);
		userIds.remove(this.userId);
	}
	
	public void broadcast(Set<ChatSocket>  ss ,String msg ){
		
		for (Iterator iterator = ss.iterator(); iterator.hasNext();) {
			ChatSocket chatSocket = (ChatSocket) iterator.next();
			try {
				chatSocket.session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
