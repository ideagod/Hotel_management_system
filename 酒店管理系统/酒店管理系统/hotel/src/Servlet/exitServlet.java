package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user_name");
		session.removeAttribute("passwd");
		session.removeAttribute("name");
		session.removeAttribute("sex");
		session.removeAttribute("list1");
		session.removeAttribute("list2");
		session.removeAttribute("list3");
		session.removeAttribute("list4");
		session.removeAttribute("list5");
		session.removeAttribute("cust1");
		session.removeAttribute("cust2");
		session.removeAttribute("cust3");
		session.removeAttribute("cust4");
		response.sendRedirect("/hotel/jsp/login.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

	

}
