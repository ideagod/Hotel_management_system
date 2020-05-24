package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Daolmpl.UserDaoImpl;
import javabean.User;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String user_name = request.getParameter("user_name");
		String passwd= request.getParameter("passwd");		
		User inputUser = new User();
		inputUser.setUser_name(user_name);
		inputUser.setPasswd(passwd);
		UserDaoImpl userDao = new UserDao(); //Dao层
		User rsUser=userDao.findByUser(inputUser);
	
		if (rsUser == null) {
			response.getWriter()
					.append("<script>alert('对不起，没有这个人！');window.location.href='/hotel/jsp/login.jsp'</script>");
		} else {
		
			if (passwd.equals(rsUser.getPasswd())) {
		
				
					String loginName = rsUser.getUser_name();
					System.out.println("登陆成功：" + loginName);
					HttpSession session = request.getSession();
					session.setAttribute("user_name", loginName);
					session.setAttribute("passwd", passwd);
					session.setAttribute("name", rsUser.getName());
					session.setAttribute("sex", rsUser.getSex());
					response.sendRedirect("/hotel/index.jsp");
				} 	
			else {
				response.getWriter()
						.append("<script>alert('对不起，密码错误！');window.location.href='/hotel/jsp/login.jsp'</script>");
			}
	
		
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}



}
