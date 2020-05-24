package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Daolmpl.UserDaoImpl;


public class re_passwordServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
		String user_name = request.getParameter("user_name");
		String fir_password = request.getParameter("fir_password");
		String password3 = request.getParameter("password3");
		String password4 = request.getParameter("password4");
		HttpSession session = request.getSession();
		String passwd = (String)session.getAttribute("passwd");
	if(fir_password.equals(passwd)==false)
		
	{
		System.out.println("原密码错误！");
		response.getWriter().append("<script>alert('原密码错误！');window.location.href='/hotel/jsp/re_password.jsp'</script>");
		
	}
	else if(!password3 .equals(password4))
	{
		System.out.println("两次密码不一致！");
		response.getWriter().append("<script>alert('两次密码不一致错误！');window.location.href='/hotel/jsp/re_password.jsp'</script>");
	}
	else{

		UserDaoImpl user=new UserDao();
		int a =user.re_password(password3, user_name);

		if(a!=0) {
			session.removeAttribute("passwd");
			session.setAttribute("passwd",password3);
			response.getWriter().append("<script>alert('修改成功！');window.location.href='/hotel/jsp/re_password.jsp'</script>");
		}else {
			response.getWriter().append("<script>alert('修改失败！');window.location.href='/hotel/jsp/re_password.jsp'</script>");
		}					
	}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
