package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

import com.exam.controller.company.HistoryController;
import com.exam.controller.company.WelcomeController;
import com.exam.controller.member.JoinIdDupCheckController;
import com.exam.controller.member.MemberJoinController;
import com.exam.controller.member.MemberJoinProController;
import com.exam.controller.member.MemberLoginController;
import com.exam.controller.member.MemberLoginProController;
import com.exam.controller.member.MemberLogoutController;
import com.exam.controller.notice.NoticeController;

public class ControllerFactory {
	
	private static ControllerFactory instance = new ControllerFactory();
	
	public static ControllerFactory getInstance() {
		return instance;
	}

	///////////////////////////////////////////////////////////

	private Map<String, Controller> map = new HashMap<>();
	
	private ControllerFactory() {
		// 명령어와 명령어를 처리하는 컨트롤러 객체를 쌍으로 등록함
		map.put("/index", new IndexController());
		
		// company
		map.put("/welcome", new WelcomeController());
		
		// history
		map.put("/history", new HistoryController());
		
		// member
		map.put("/memberJoin", new MemberJoinController());
		map.put("/joinIdDupCheck", new JoinIdDupCheckController());
		map.put("/memberJoinPro", new MemberJoinProController());
		map.put("/memberLogin", new MemberLoginController());
		map.put("/memberLoginPro", new MemberLoginProController());
		map.put("/memberLogout", new MemberLogoutController());
		
		// notice 게시판
		map.put("/notice", new NoticeController());
		
	} // 생성자
	
	public Controller getController(String command) {
		// Map 컬렉션은 키값이 존재하지않는 값을 꺼내면 null을 리턴함
		Controller controller = map.get(command);
		return controller;
	}
}
