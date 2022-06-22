package com.mouse.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.mouse.dao.MouseDAO;
import com.mouse.model.Mouse;

public class MouseService {
	//singleton 패턴, 해당 프로그램에서 인스턴스(객체)가 단 하나만 생성됨을 보장. 같은 주소값만으로 반환
	
	//필드 생성
	private static MouseService service = new MouseService();
	private MouseDAO dao = MouseDAO.getInstance();
	
	//기본 생성자
	private MouseService () {}
	
	
	//별도의 메서드를  통해서 이미 생성된 인스턴스를 반환
	public static MouseService getInstance(){
		return service;
	}
	
	

	
	//service -> dao
	public ArrayList<Mouse> mouseList() throws SQLException {
		ArrayList<Mouse> mouseList = dao.mouseList();
		return mouseList;
	}


	public int mouseInsert(Mouse mouse) {
		int result = dao.mouseInsert(mouse);
		return result;
	}


	public Mouse mouseRead(String id) {
		return dao.mouseRead(id);
	}


	public int mouseUpdate(Mouse mouse) {
		int result = dao.mouseUpdate(mouse);
		return result;
	}


	public int mouseDelete(Mouse mouse) {
		int result = dao.mouseDelete(mouse);
		return result;
	}
	
	
	
	
}
