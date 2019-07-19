package com.kai.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Response;

public class DBHelper {
	private Connection con;
	private Statement st;
	private ResultSet rs;

	public DBHelper() {
		try {
			// Class ���R�A forName() ��k��{�ʺA�[�����O
			Class.forName("com.mysql.jdbc.Driver");
			// 3306|MySQL�}�񦹺ݤf
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/forhomework?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "kai@gj94ek712114");
			st = con.createStatement();

		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}
	}

	public static void closeDb(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public ArrayList<User> getData() {
		ArrayList<User> result = new ArrayList<User>();
		try {
			String query = "select * from login_inf";
			rs = st.executeQuery(query);
			System.out.println("Records for Database");
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				result.add(user);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return result;
	}

	public boolean iscurrect(String account, String password) throws SQLException {
		boolean reaccept = false;
		// sql�y�y�A�j�M�o�� account �M password�b��Ʈw�O�_�s�b
		String sql = "select * from login_inf where account='" + account + "'and password='" + password + "'";
		rs=st.executeQuery(sql);
		if(rs.next() != true) {
			reaccept = false;
		}else {
			reaccept = true;
		}
		return reaccept;
		
		
		/*
		if (rs != null) {
			reaccept = true;
		} else {
			reaccept = false;
		}
		return reaccept;
		*/
	}
	
	public boolean create_account(String into_account, String into_password) throws SQLException {
		boolean create_reslut = false;
		//�إ�Statement����
		Statement st=con.createStatement();
		//sql�y�y�A�s�W�b���αK�X�iDB
		String sql="INSERT INTO login_inf (account,password) VALUE('" + into_account + "','" + into_password + "')";
		System.out.print(sql);
		try {
			st.execute(sql);
			return create_reslut = true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
			return create_reslut = false;
		}


		
	}
}
