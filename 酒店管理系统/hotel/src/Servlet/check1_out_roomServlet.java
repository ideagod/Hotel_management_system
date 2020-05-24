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
import Dao.RoomDao;
import Daolmpl.CustomerDaoImpl;
import Daolmpl.RoomDaoImpl;

public class check1_out_roomServlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
	  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			String room_num = request.getParameter("room_num");
			String in_day= request.getParameter("in_day");
			String in_time= request.getParameter("in_time");
			String out_time= request.getParameter("out_time");
			
			int in_day1=Integer.valueOf(request.getParameter("in_day")).intValue();
			CustomerDaoImpl customerDao = new CustomerDao();
			customer cust=new customer();
			cust=customerDao.select1_customer(room_num);
			cust.setOut_time(out_time);
			RoomDaoImpl roomDao = new RoomDao();
			
			double price= roomDao.find_price_Room(room_num);//查看房间价格
			double allprice=price*cust.getIn_day(); 
			cust.setPrice(allprice);
			int a=customerDao.set_customer(cust);  //存客户至另一个表
			int b=customerDao.delete_customer(room_num);   //将客户从customer表移去
			
			
			
			
			int c=roomDao.re_room_is_empty2(room_num);
			if(a!=0&&b!=0&&c!=0) {	
				response.getWriter().append("<script>alert('退房成功 ！共"+allprice+"元');window.location.href='/hotel/check_out_roomServlet.do'</script>");
			}else {
				response.getWriter().append("<script>alert('退房失败！');window.location.href='/hotel/check_out_roomServlet.do'</script>");
			}
		
			
			
	    }     
}

