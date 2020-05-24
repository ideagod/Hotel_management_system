package Dao;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabean.Room;
import javabean.User;
import javabean.customer;
import javabean.pageResult;
import Daolmpl.CustomerDaoImpl;

import JDBC.JDBCUtil;

public class CustomerDao implements CustomerDaoImpl {
	//添加客户
	public int in_customer(customer cust) {

		String sql1= "insert into customer" +
				"(name,phone,sex,id_card,in_time,in_day,room_num)" +
				"values(?,?,?,?,?,?,?);";		
		String in_day1=String.valueOf(cust.getIn_day());
		String[] info1= {cust.getUsername(),cust.getPhone(),cust.getSex(),
				cust.getId_card(),cust.getIn_time(),in_day1,cust.getRoom_num()};
		int rs =JDBCUtil.executeUpdate(sql1, info1);
		return rs;
	}
	
	//客户续房
	public int renew_room(int new_day,String room_num) {
		String new_day1=String.valueOf(new_day);
		String sql2 = "update customer set in_day=? where room_num=?;";
		String[] info2 = {new_day1,room_num};

		int rs =JDBCUtil.executeUpdate(sql2, info2);//完成插入的操作
		
		return rs;
	}
	
	//分页功能
	public pageResult<customer> find_customer_bypage(int page) throws SQLException
	 {		
			String sql2 = "select count(*) page from customer;";
			
			ResultSet rs = JDBCUtil.executeQuery(sql2, null);
	     //1.创建pageresult对象
	     pageResult<customer> pr = new pageResult<customer>();
	     //2.设置总记录数
	     rs.next();
	     int totalcount = rs.getInt("page");
	     pr.setTotalCount(totalcount);
	           //3.设置总页数
	     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
	     pr.setTotalpage(totalpage);
	     //4.设置当前页
	     pr.setCurrentPage(page);
	     //5.放置list参数
	     int start = (page-1)* pr.getPageCount();
	     List<customer> user = find_customer_All(start,pr.getPageCount());
	     pr.setList(user); 
	     return pr;
	    }
	//分页查找
	public List<customer> find_customer_All(int star,int page) {
		String star1=String.valueOf(star);
		String page1=String.valueOf(page);
		String sql = "select * from customer limit "+star1+","+page1;
		ResultSet rs = JDBCUtil.executeQuery(sql,null);
		List<customer> customerAllList = new ArrayList<customer>();
		try {
			while (rs.next()) {
				customer ro = new customer();
				ro.setUsername(rs.getString("name"));
				ro.setPhone(rs.getString("phone"));
				ro.setRoom_num(rs.getString("room_num"));
				ro.setId_card(rs.getString("id_card"));
				ro.setSex(rs.getString("sex"));
				ro.setIn_time(rs.getString("in_time"));
				ro.setIn_day(rs.getInt("in_day"));
				customerAllList.add(ro);					
			}
			return customerAllList;
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	
	//分页功能
		public pageResult<customer> select_customer_bypage(int page,String customer_information) throws SQLException
		 {		
				String sql2 = "select count(*) page from customer where name like '%"+customer_information+"%' or phone like '%"+customer_information+"%' or id_card like '%"+customer_information+"%' or room_num like '%"+customer_information+"%';";
				
				ResultSet rs = JDBCUtil.executeQuery(sql2, null);
		     //1.创建pageresult对象
		     pageResult<customer> pr = new pageResult<customer>();
		     //2.设置总记录数
		     rs.next();
		     int totalcount = rs.getInt("page");
		     pr.setTotalCount(totalcount);
		           //3.设置总页数
		     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
		     pr.setTotalpage(totalpage);
		     //4.设置当前页
		     pr.setCurrentPage(page);
		     //5.放置list参数
		     int start = (page-1)* pr.getPageCount();
		     List<customer> user = select_customer_All(start,pr.getPageCount(),customer_information);
		     pr.setList(user); 
		    List<customer> userq= pr.getList();
		     return pr;
		    }
		//分页查找
		public List<customer> select_customer_All(int star,int page,String customer_information) {
			String star1=String.valueOf(star);
			String page1=String.valueOf(page);
			String sql = "select * from customer where name like '%"+customer_information+"%' or phone like '%"+customer_information+"%' or id_card like '%"+customer_information+"%' or room_num like '%"+customer_information+"%' limit "+star1+","+page1;
			ResultSet rs = JDBCUtil.executeQuery(sql,null);
			List<customer> customerAllList = new ArrayList<customer>();
			try {
				while (rs.next()) {
					customer ro = new customer();
					ro.setUsername(rs.getString("name"));
					ro.setPhone(rs.getString("phone"));
					ro.setRoom_num(rs.getString("room_num"));
					ro.setId_card(rs.getString("id_card"));
					ro.setSex(rs.getString("sex"));
					ro.setIn_time(rs.getString("in_time"));
					ro.setIn_day(rs.getInt("in_day"));
					customerAllList.add(ro);					
				}
				
				
				return customerAllList;
			} catch (SQLException e) {		
				e.printStackTrace();
			}
			return null;
		}
	//查询客户
	public List<customer> select_customer(String customer_information) {
	
		String sql = "select * from customer where name like '%"+customer_information+"%' or phone like '%"+customer_information+"%' or id_card like '%"+customer_information+"%' or room_num like '%"+customer_information+"%';";
	
			//String[] info = { null};
		ResultSet rs = JDBCUtil.executeQuery(sql, null);
	
		
			List<customer> customerList = new ArrayList<customer>();
			try {
			while (rs.next()) {
				customer ro = new customer();
				ro.setUsername(rs.getString("name"));
				ro.setPhone(rs.getString("phone"));
				ro.setRoom_num(rs.getString("room_num"));
				ro.setId_card(rs.getString("id_card"));
				ro.setSex(rs.getString("sex"));
				ro.setIn_time(rs.getString("in_time"));
				ro.setIn_day(rs.getInt("in_day"));
				customerList.add(ro);
			
			}
			return customerList;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		
		}
	

		return null;// 如果没有这个人则返回null
	}
	
	//普通查询客户
	public customer select1_customer(String room_num) {
		
		String sql = "select * from customer where  room_num=?;";
		String[] info = {room_num};
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
			customer ro = new customer();
			try {
			while (rs.next()) {
				ro.setUsername(rs.getString("name"));
				ro.setPhone(rs.getString("phone"));
				ro.setRoom_num(rs.getString("room_num"));
				ro.setId_card(rs.getString("id_card"));
				ro.setSex(rs.getString("sex"));
				ro.setIn_time(rs.getString("in_time"));
				ro.setIn_day(rs.getInt("in_day"));	
				return ro;
			}
		} catch (SQLException e) {
			e.printStackTrace();				
		}
	

		return null;// 如果没有这个人则返回null
	}
	
	//退房客户信息转存至checkout_customer表
	public int set_customer(customer cust) {
		
		String sql7 = "insert into checkout_customer(name,phone,sex,id_card,in_time,in_day,room_num,out_time,price)values(?,?,?,?,?,?,?,?,?);";
		String in_day1=String.valueOf(cust.getIn_day());
		String price = String.valueOf(cust.getPrice());
		// double price=Double.valueOf(cust.getPrice()).doubleValue();
		String[] info7 = {cust.getUsername(),cust.getPhone(),cust.getSex(),cust.getId_card()
				,cust.getIn_time(),in_day1,cust.getRoom_num(),cust.getOut_time(),price};
		int rs =JDBCUtil.executeUpdate(sql7, info7);
		return rs;
	}
	
	//退房客户信息从customer表移去
	public int delete_customer(String room_num) {

		String sql ="delete from customer where room_num=?;";
		String[] info = {room_num};
		int rs =JDBCUtil.executeUpdate(sql, info);
		return rs;
	}
	
	//分页功能
		public pageResult<customer> find_old_customer_bypage(int page) throws SQLException
		 {		
				String sql2 = "select count(*) page from checkout_customer;";
				
				ResultSet rs = JDBCUtil.executeQuery(sql2, null);
		     //1.创建pageresult对象
		     pageResult<customer> pr = new pageResult<customer>();
		     //2.设置总记录数
		     rs.next();
		     int totalcount = rs.getInt("page");
		     pr.setTotalCount(totalcount);
		           //3.设置总页数
		     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
		     pr.setTotalpage(totalpage);
		     //4.设置当前页
		     pr.setCurrentPage(page);
		     //5.放置list参数
		     int start = (page-1)* pr.getPageCount();
		     List<customer> user = find_old_customer_All(start,pr.getPageCount());
		     pr.setList(user); 
		    List<customer> userq= pr.getList();
		     return pr;
		    }
		//分页查找
		public List<customer> find_old_customer_All(int star,int page) {
			String star1=String.valueOf(star);
			String page1=String.valueOf(page);
			String sql = "select * from checkout_customer limit "+star1+","+page1;
			ResultSet rs = JDBCUtil.executeQuery(sql,null);
			List<customer> customerAllList = new ArrayList<customer>();
			try {
				while (rs.next()) {
					customer ro = new customer();
					ro.setUsername(rs.getString("name"));
					ro.setPhone(rs.getString("phone"));
					ro.setRoom_num(rs.getString("room_num"));
					ro.setId_card(rs.getString("id_card"));
					ro.setSex(rs.getString("sex"));
					ro.setIn_time(rs.getString("in_time"));
					ro.setOut_time(rs.getString("out_time"));
					ro.setIn_day(rs.getInt("in_day"));
					ro.setPrice(rs.getDouble("price"));
					customerAllList.add(ro);					
				}
				return customerAllList;
			} catch (SQLException e) {		
				e.printStackTrace();
			}
			return null;
		}
		//分页功能
		public pageResult<customer> select_old_customer_bypage(int page,String customer_information) throws SQLException
		 {		
				String sql2 = "select count(*) page from checkout_customer where name like '%"+customer_information+"%' or phone like '%"+customer_information+"%' or id_card like '%"+customer_information+"%' or room_num like '%"+customer_information+"%';";
				
				ResultSet rs = JDBCUtil.executeQuery(sql2, null);
		     //1.创建pageresult对象
		     pageResult<customer> pr = new pageResult<customer>();
		     //2.设置总记录数
		     rs.next();
		     int totalcount = rs.getInt("page");
		     pr.setTotalCount(totalcount);
		           //3.设置总页数
		     int totalpage = (int) (totalcount % pr.getPageCount() == 0 ? totalcount / pr.getPageCount() : totalcount / pr.getPageCount() + 1);
		     pr.setTotalpage(totalpage);
		     //4.设置当前页
		     pr.setCurrentPage(page);
		     //5.放置list参数
		     int start = (page-1)* pr.getPageCount();
		     List<customer> user = select_old_customer_All(start,pr.getPageCount(),customer_information);
		     pr.setList(user); 
		    List<customer> userq= pr.getList();
		     return pr;
		    }
		//分页查找
		public List<customer> select_old_customer_All(int star,int page,String customer_information) {
			String star1=String.valueOf(star);
			String page1=String.valueOf(page);
			String sql = "select * from checkout_customer where name like '%"+customer_information+"%' or phone like '%"+customer_information+"%' or id_card like '%"+customer_information+"%' or room_num like '%"+customer_information+"%' limit "+star1+","+page1;
			ResultSet rs = JDBCUtil.executeQuery(sql,null);
			List<customer> customerAllList = new ArrayList<customer>();
			try {
				while (rs.next()) {
					customer ro = new customer();
					ro.setUsername(rs.getString("name"));
					ro.setPhone(rs.getString("phone"));
					ro.setRoom_num(rs.getString("room_num"));
					ro.setId_card(rs.getString("id_card"));
					ro.setSex(rs.getString("sex"));
					ro.setIn_time(rs.getString("in_time"));
					ro.setIn_day(rs.getInt("in_day"));
					ro.setPrice(rs.getDouble("price"));
					customerAllList.add(ro);					
				}
				
				
				return customerAllList;
			} catch (SQLException e) {		
				e.printStackTrace();
			}
			return null;
		}
	
}
