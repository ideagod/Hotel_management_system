package JDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;

public class JDBCUtil {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/hotel?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PASSWORD ="";
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Connection ct = null;

	static {
	
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		Connection ct = null;
		try {
			ct = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ct;
	}

	public static ResultSet executeQuery(String sql, String[] info) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);

			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					ps.setString(1 + i, info[i]);
				}
			}
	
			rs = ps.executeQuery();
		
			return rs;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static int executeUpdate(String sql, String[] info) {
		try {
			ct = getConnection();
			ps = ct.prepareStatement(sql);
			
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					ps.setString(1 + i, info[i]);
				}
			}

			int in = ps.executeUpdate();

			if (in != 0) {
				System.out.println("操作成功!");
			} else {
				System.out.println("操作失败！！");
			}
			return in;

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(ct, ps, null);
		}
		return 0;

	}
	
	public static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}

	public static void close(Connection ct, PreparedStatement ps, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			rs = null;
		} catch (SQLException e) {
	
			e.printStackTrace();
		}

		try {
			if (ps != null) {
				ps.close();
			}
			ps = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		try {
			if (ct != null) {
				ct.close();
			}
			ct = null;
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
