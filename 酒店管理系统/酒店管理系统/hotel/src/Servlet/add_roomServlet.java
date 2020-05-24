package Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.RoomDao;
import Daolmpl.RoomDaoImpl;
import javabean.Room;
import javabean.pageResult;



public class add_roomServlet extends HttpServlet {

	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  
	    {  
	        doPost(request, response);  
	    }  

	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {  
	  

			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");	
			String pageStr = request.getParameter("page");
			String is_empty = request.getParameter("is_empty");
			int page =1;
			if(pageStr!=null && !"".equals(pageStr))
			{
				page = Integer.parseInt(pageStr);
			}
		
			RoomDaoImpl RoomDao = new RoomDao();
			pageResult<Room> roomlist = null;
			try {			
			roomlist= RoomDao.find_room_bypage(page);
			System.out.println(roomlist);		
			HttpSession session = request.getSession();
			session.setAttribute("list1",  roomlist);
			response.sendRedirect("tgls/agent/agent_add.jsp");
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	    }     
}

