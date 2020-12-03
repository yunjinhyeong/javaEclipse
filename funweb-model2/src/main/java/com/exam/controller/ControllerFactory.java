package com.exam.controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
	
	private Map<String, Controller> map = new HashMap<>();
	
	
	public ControllerFactory() {
		// ��ɾ�� ��ɾ ó���ϴ� ��Ʈ�ѷ� ��ü�� ������ �����
		map.put("/index", new IndexController());
		
	} // ������
	

	
	public Controller getController(String command) {
		// Map �÷����� Ű���� ���������ʴ� ���� ������ null�� ������
		Controller controller = map.get(command);
		return controller;
	}
	
}
