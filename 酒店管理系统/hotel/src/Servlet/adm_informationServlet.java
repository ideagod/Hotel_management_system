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

import javabean.User;


public class adm_informationServlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			HttpSession session = request.getSession();
			String now_name = (String) session.getAttribute("user_name");
			User select = new User();
			select.setUser_name(now_name);
			UserDaoImpl userDao = new UserDao(); //Dao²ã
			User rsUser=userDao.findByUser(now_name);	        
			request.setAttribute("rsUser", rsUser);	
				request.getRequestDispatcher("/jsp/adm_information.jsp").forward(request, response);

	    }     
}
