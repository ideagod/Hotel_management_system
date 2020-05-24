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
import Dao.RoomDao;
import Daolmpl.CustomerDaoImpl;
import Daolmpl.RoomDaoImpl;


public class customer_in_Servlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
	  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");	
		/*	//分页
			String pageStr = request.getParameter("page");
			int page =1;
			if(pageStr!=null && !"".equals(pageStr))
			{
				page = Integer.parseInt(pageStr);
			}
		*/
			//获取客户信息
			String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
			String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
			String phone= request.getParameter("phone");
			String  id_card= request.getParameter("id_card");
			String in_time = request.getParameter("in_time");
			String in_day = request.getParameter("in_day");
			String room_num = request.getParameter("room_num");
		//	String room_num2= request.getParameter("room_num");
		
			int in_day1=Integer.valueOf(in_day).intValue();
			response.sendRedirect("tgls/agent/agent_add.jsp");
			customer cust=new customer();
			cust.setId_card(id_card);
			cust.setIn_day(in_day1);
			cust.setPhone(phone);
			cust.setSex(sex);
			cust.setUsername(username);
			cust.setIn_time(in_time);
			cust.setRoom_num(room_num);

			CustomerDaoImpl custom = new CustomerDao();
			int a=custom.in_customer(cust);
			if(a!=0) { 	
				RoomDaoImpl RoomDao = new RoomDao();
				RoomDao.re_room_is_empty1(room_num);
				response.getWriter().append("<script>alert('添加成功！');window.location.href='tgls/agent/agent_add.jsp'</script>");
			}else {
				response.getWriter().append("<script>alert('添加失败！');window.location.href='tgls/agent/agent_add.jsp'</script>");
			}
			
		
	    }  

}
