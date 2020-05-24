package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javabean.customer;
import javabean.pageResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CustomerDao;
import Daolmpl.CustomerDaoImpl;

public class select_check_out_customerServlet extends HttpServlet {
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
			System.out.println("≤‚ ‘2"+customer_information);
			CustomerDaoImpl customerDao = new CustomerDao(); //Dao≤„
			pageResult<customer> cust2=customerDao.select_customer_bypage(page, customer_information);
			 session.setAttribute("cust2", cust2);	
				response.sendRedirect("tgls/agent/select_check_out_room.jsp");
		}
		catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("tgls/agent/not_select.jsp");
		} }
}
