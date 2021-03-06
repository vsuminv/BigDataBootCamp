package com.mouse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mouse.model.Mouse;
import com.mouse.util.DBUtils;

public class MouseDAO {

	// singleton
	// 인스턴스 직접 선언, 초기화
	private static MouseDAO dao = new MouseDAO();
	PreparedStatement pstmt; // 아래 메소드 사용하기 위해 필드 추가

	// 기본 생성자에 대한 접근 제한, private이면 클래스 내부(본인만)에서 접근 가능
	private MouseDAO() {
	}

	// 기본적으로 private으로 작성하는 방향으로 코딩하다가 특정 상황에서
	// 이 메서드는 외부에 공개가 필요하겠다라는 메서드들만 상황에 맞게 접근 제어자를 변경
	public static MouseDAO getInstance() {
		return dao;
	}

	// findAll, 전체mouse 데이터 조회
	public ArrayList<Mouse> mouseList() throws SQLException { // 예외 발생 시 예외에 대한 처리를 해당 메서드를 호출한 쪽으로 위임
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Mouse mouse = null;
		ArrayList<Mouse> mouseList = null;
		String sql = "SELECT * FROM mouse;";

		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			mouseList = new ArrayList<Mouse>();

			while (rs.next()) {
				mouse = new Mouse();
				mouse.setId(rs.getInt(1));
				mouse.setName(rs.getString(2));
				mouse.setCountry(rs.getString(3));
				mouse.setAddress(rs.getString(4));

				mouseList.add(mouse);
			}
		} finally {
			// 자원 해제
			rs.close();
			pstmt.close();
			conn.close();
		}

		return mouseList;
	}

	public int mouseInsert(Mouse mouse) {
		String sql = "INSERT INTO mouse(name,country,address) VALUES(?,?,?)";

		try (Connection con = DBUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, mouse.getName());
			pstmt.setString(2, mouse.getCountry());
			pstmt.setString(3, mouse.getAddress());

			// DB Query 수행
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public Mouse mouseRead(String id) {
		String sql = "SELECT * FROM mouse where id = ?";
		Mouse mouse = null; //리턴하기위해 try밖에서 만들기
		try (Connection con = DBUtils.getConnection(); 
				PreparedStatement pstmt = createPstmt(con,sql,id);
				ResultSet rs = pstmt.executeQuery();) {

			
				if(rs.next()) {
					mouse = new Mouse();
					mouse.setId(rs.getInt(1));
					mouse.setName(rs.getString(2));
					mouse.setCountry(rs.getString(3));
					mouse.setAddress(rs.getString(4));
				}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return mouse;
	}

	private PreparedStatement createPstmt(Connection con, String sql, String id) throws SQLException {
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id)); //ReadController에서 getparameter는 문자열로 받기 떄문에 변환해줘야함
		return pstmt;
	}

	public int mouseUpdate(Mouse mouse) {
		String sql = "UPDATE mouse SET id = ?, name = ?, country = ?, address = ? where id = ? ";


		try (Connection con = DBUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, mouse.getId());
			pstmt.setString(2, mouse.getName());
			pstmt.setString(3, mouse.getCountry());
			pstmt.setString(4, mouse.getAddress());
			pstmt.setInt(5, mouse.getId());

			// DB Query 수행
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int mouseDelete(Mouse mouse) {
		String sql = "DELETE FROM mouse  where id = ? ";
		try (Connection con = DBUtils.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			pstmt.setInt(1, mouse.getId());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

	
}
