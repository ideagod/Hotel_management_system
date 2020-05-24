package Daolmpl;

import javabean.User;

public interface UserDaoImpl {
	public User findByUser(User user);
	public int re_password(String password,String user_name);
	public User findByUser(String user_name);
}

