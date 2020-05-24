package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.CustomerDao;
import Dao.RoomDao;
import Daolmpl.CustomerDaoImpl;
import Daolmpl.RoomDaoImpl;
import javabean.customer;

import java.sql.SQLException;

import java.util.Date;

/**
 * Servlet implementation class DatabaseAccess
 */
@WebServlet("/DatabaseAccess")
public class checkin_servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    // JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/hotel?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = ""; 
    /**
     * @see HttpServlet#HttpServlet()
     */
   // public checkin_servlet() {
      //  super();
        // TODO Auto-generated constructor stub
    //}

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);     
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Connection conn = null;
        Statement stmt = null;
        // 设置响应内容类型
        request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String title = "Servlet Mysql 测试 - 菜鸟教程";
        String docType = "<!DOCTYPE html>\n";
        String room_num ="401";
        out.println(docType +
        "<html>\n" +
        "<head><title>" + title + "</title></head>\n" +
        "<body bgcolor=\"#f0f0f0\">\n" +
        "<h1 align=\"center\">" + title + "</h1>\n");
        try{
            // 注册 JDBC 驱动器
            Class.forName("com.mysql.jdbc.Driver");
            
            // 打开一个连接
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            // 执行 SQL 查询
            stmt = conn.createStatement();
            String sql;
            String username= request.getParameter("username");
    		String id_card= request.getParameter("id_card");
    		String sex= request.getParameter("sex");
    		String phone= request.getParameter("phone");
    		String room= request.getParameter("room");
    		String datetimepicker1= request.getParameter("datetimepicker1");
    		String datetimepicker2= request.getParameter("datetimepicker2");
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
    		Date date1 = sdf.parse(datetimepicker1);
    		Date date2 = sdf.parse(datetimepicker2);
    		long temp =((date2.getTime()-date1.getTime())/(1000*24*60*60));
    		int in_day1= Integer.parseInt(String.valueOf(temp));
    		String in_time=datetimepicker1;
    		
    		//Date date = new Date()；
    		out.println("姓名"+username);
    		out.println("身份证"+id_card);
    		out.println("电话"+phone);
    		out.println("性别"+sex);
    		out.println("入住日期"+datetimepicker1);
    		out.println("退房日期"+datetimepicker2);
    		out.println("天数"+in_day1);
            sql = "SELECT room_num FROM room where is_empty='1' and room_num like'"+room+"%' limit 1" ;
            ResultSet rs = stmt.executeQuery(sql);
			// 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
            	room_num = rs.getString("room_num");
                // 输出数据
                out.println("房间号: " + room_num );
                out.println("<br />");
            }
            customer cust=new customer();
  			cust.setId_card(id_card);
  			cust.setIn_day(in_day1);
  			cust.setPhone(phone);
  			cust.setSex(sex);
  			cust.setUsername(username);
  			cust.setIn_time(in_time);
  			cust.setRoom_num(room_num);
  			response.sendRedirect("/hotel/welcome.jsp");
  			CustomerDaoImpl custom = new CustomerDao();
  			int a=custom.in_customer(cust);
  			if(a!=0) { 	
  				RoomDaoImpl RoomDao = new RoomDao();
  				RoomDao.re_room_is_empty1(room_num);
  				response.getWriter().append("<script>alert('预订房间成功！');window.location.href='/hotel/welcome.jsp'</script>");
  			}
  			else{
  				response.getWriter().append("<script>alert('预订房间失败！');window.location.href='/hotel/welcome.jsp'</script>");
  			}
            out.println("</body></html>");

            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch(Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 最后是用于关闭资源的块
            try{
                if(stmt!=null)
                stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}