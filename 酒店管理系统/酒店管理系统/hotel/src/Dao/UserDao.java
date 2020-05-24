package Dao;

import java.sql.ResultSet; 
import java.sql.SQLException;

import javabean.User;
import Daolmpl.UserDaoImpl;
import JDBC.JDBCUtil;

public class UserDao implements UserDaoImpl {
	public User findByUser(User user) {
		String sql = "select * from User where user_name=? ;";
		String[] info = { user.getUser_name() };
		ResultSet rs = JDBCUtil.executeQuery(sql, info);

		try {
			User rsUser = new User();
			while (rs.next()) {
			
				rsUser.setId(rs.getString("id"));
				rsUser.setUser_name(rs.getString("User_name"));
				rsUser.setPasswd(rs.getString("passwd"));
				rsUser.setName(rs.getString("name"));
				rsUser.setPhone(rs.getString("phone"));
				rsUser.setSex(rs.getString("SEX"));
			
				return rsUser;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;// 如果没有这个人则返回null
	}
	public User findByUser(String user_name) {
		String  sql = "select * from User where user_name=?;";
		String info[] = {user_name};
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		
	
			User user = new User();
			try {
				while(rs.next()) {	
					user.setId(rs.getString("id"));
					user.setName(rs.getString("name"));
					user.setUser_name(rs.getString("user_NAME"));
					user.setSex(rs.getString("sex"));
					user.setPhone(rs.getString("phone"));
					user.setPasswd(rs.getString("passwd"));
					return user;
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	
		return null;
	}
	//修改密码
	public int re_password(String password,String user_name) {
		
		String sql5 = "update user set passwd=? where user_name=?;";
		String[] info5 = {password,user_name};

		int rs =JDBCUtil.executeUpdate(sql5, info5);//完成插入的操作
		
		return rs;
	}
	
}
