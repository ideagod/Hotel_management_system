package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.customer;
import javabean.pageResult;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.CustomerDao;
import Daolmpl.CustomerDaoImpl;


public class customer_information_Servlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
	  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");	
			String pageStr = request.getParameter("page");
			int page =1;
			if(pageStr!=null && !"".equals(pageStr))
			{
				page = Integer.parseInt(pageStr);
			}
		
			CustomerDaoImpl customerDao = new CustomerDao();
			pageResult<customer> customerlist = null;
			try {			
				customerlist= customerDao.find_customer_bypage(page);
			System.out.println(customerlist);		
			HttpSession session = request.getSession();
			session.setAttribute("list2", customerlist);
			response.sendRedirect("tgls/agent/customer_in.jsp");
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }     
}
