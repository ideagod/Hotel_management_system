package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javabean.Room;
import javabean.customer;
import javabean.pageResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CustomerDao;
import Daolmpl.CustomerDaoImpl;
import java.util.ArrayList;
import java.util.List;
public class select_customerServlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String pageStr = request.getParameter("page");
			HttpSession session = request.getSession();
			int page =1;
			if(pageStr!=null && !"".equals(pageStr))
			{
				page = Integer.parseInt(pageStr);
			}
		
			try
			{
			String customer_information =new String(request.getParameter("customer_information").getBytes("ISO-8859-1"),"UTF-8");
			System.out.println("≤‚ ‘1"+customer_information);
			CustomerDaoImpl customerDao = new CustomerDao(); //Dao≤„
			pageResult<customer> cust1=customerDao.select_customer_bypage(page, customer_information);
			 session.setAttribute("cust1", cust1);	
				response.sendRedirect("tgls/agent/select_customer.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("tgls/agent/not_select.jsp");
		} }
}
