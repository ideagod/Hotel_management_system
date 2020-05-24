package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javabean.customer;
import javabean.pageResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.CustomerDao;
import Dao.RoomDao;
import Daolmpl.CustomerDaoImpl;
import Daolmpl.RoomDaoImpl;

public class renew1_roomServlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
	  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");	
		
			String room_num = request.getParameter("room_num");
			int renew_day =Integer.valueOf(request.getParameter("renew_day")).intValue();
			int in_day=Integer.valueOf(request.getParameter("in_day")).intValue();
			int new_day=in_day+renew_day;
			CustomerDaoImpl customerDao = new CustomerDao();
			int a=customerDao.renew_room(new_day, room_num);

			if(a!=0) {
			
				response.getWriter().append("<script>alert('续房成功！');window.location.href='/hotel/renew_roomServlet.do'</script>");
			}else {
				response.getWriter().append("<script>alert('续房失败！');window.location.href='/hotel/renew_roomServlet.do'</script>");
			}
			
		
			
	    }     
}
