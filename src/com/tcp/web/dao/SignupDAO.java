package com.tcp.web.dao;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//회원가입, 아이디 및 닉네임 중복확인
//싱글톤 (중복확인과 가입사이의 무결성)
public class SignupDAO {
//	private static SignupDAO instance;
	private Properties prt;
	private Connection con;
	private Statement stm;
	private ResultSet rs;
	private String url;
	private String id;
	private String pw;
	private final String tb = "tablename";
	
	//DB 연결
	private SignupDAO() {
		try {
			prt.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("com/tcp/web/properties/jdbc.properties"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,id,pw);
			stm = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//공용 인스턴스 생성
	private static class DAOHolder {
		public static final SignupDAO INSTANCE = new SignupDAO();
	}
	
	public static SignupDAO getInstance() {
		return DAOHolder.INSTANCE;
	}
	
}
