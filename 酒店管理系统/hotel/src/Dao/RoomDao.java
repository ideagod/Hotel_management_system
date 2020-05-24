package Dao;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javabean.Room;
import javabean.pageResult;
import Daolmpl.RoomDaoImpl;

import JDBC.JDBCUtil;


public class RoomDao implements RoomDaoImpl {
	//普通查询
	public List<Room> findAll() {
		String sql = "select * from room ;";
		
		ResultSet rs = JDBCUtil.executeQuery(sql,null);
		List<Room> rsList = new ArrayList<Room>();

		try {
		
			while (rs.next()) {
				Room rsRoom = new Room();
				// 将从数据库中得到的信息放到对象中
				rsRoom.setType(rs.getString("type"));
				rsRoom.setIs_empty(rs.getString("is_empty"));
				rsRoom.setRoom_num(rs.getString("room_num"));
				rsRoom.setPrice(rs.getDouble("price"));
				rsRoom.setImg(rs.getString("img"));
				rsList.add(rsRoom);
			}
			return rsList;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}

		return null;
	}
	//查询房间号
	public Room findByRoom(Room room) {
		String sql2 = "select * from room where room_num=? ;";
		String[] info2 = { room.getRoom_num() };
		ResultSet rs = JDBCUtil.executeQuery(sql2, info2);

		try {
			Room rsRoom = new Room();
			while (rs.next()) {
			
				rsRoom.setType(rs.getString("type"));
				rsRoom.setIs_empty(rs.getString("is_empty"));
				rsRoom.setRoom_num(rs.getString("room_num"));
				rsRoom.setPrice(rs.getDouble("price"));
				rsRoom.setImg(rs.getString("img"));
			
			
				return rsRoom;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;// 如果没有这个人则返回null
	}
	//查询房间号
	public Room findByRoom(String room_num) {
		String  sql3 = "select * from room where Room_num?;";
		String info3[] = {room_num};
		ResultSet rs = JDBCUtil.executeQuery(sql3, info3);
		
	
		Room rsRoom = new Room();
			try {
	
				while (rs.next()) {
				
					rsRoom.setType(rs.getString("type"));
					rsRoom.setIs_empty(rs.getString("is_empty"));
					rsRoom.setRoom_num(rs.getString("room_num"));
					rsRoom.setPrice(rs.getDouble("price"));
					rsRoom.setImg(rs.getString("img"));
				
				
					return rsRoom;
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	
		return null;
	}
	//分页功能
	public pageResult<Room> find_room_bypage(int page) throws SQLException
	 {		
			String sql4 = "select count(*) page from room where is_empty=1";
			
			ResultSet rs = JDBCUtil.executeQuery(sql4, null);
	     //1.创建pageresult对象
	     pageResult<Room> pr = new pageResult<Room>();
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
	     List<Room> user = findroomAll(start,pr.getPageCount());
	     pr.setList(user); 
	     return pr;
	    }
	//分页查找
	public List<Room> findroomAll(int star,int page) {
		String star1=String.valueOf(star);
		String page1=String.valueOf(page);
		String sql5 = "select * from room where is_empty=1 limit "+star1+","+page1;
		ResultSet rs = JDBCUtil.executeQuery(sql5,null);
		List<Room> roomAllList = new ArrayList<Room>();
		try {
			while (rs.next()) {
				Room ro = new Room();
				ro.setImg(rs.getString("img"));
				ro.setPrice(rs.getDouble("price"));
				ro.setRoom_num(rs.getString("room_num"));
				ro.setType(rs.getString("type"));
				ro.setIs_empty(rs.getString("is_empty"));
				ro.setId(rs.getInt("id"));
				roomAllList.add(ro);					
			}
			return roomAllList;
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		return null;
	}
	
	//若客户入住，则is_empty=0表示该房间被选
	public int re_room_is_empty1(String room_num) {
		String sql6 = "update room set is_empty=0 where room_num="+room_num+"; ";
		int rs =JDBCUtil.executeUpdate(sql6, null);
		return rs;
	}
	//若客户退房，则is_empty=1表示该房间空闲
	public int re_room_is_empty2(String room_num) {
		String sql6 = "update room set is_empty=1 where room_num="+room_num+"; ";
		int rs =JDBCUtil.executeUpdate(sql6, null);
		return rs;
	}
	//查询价格
	public double find_price_Room(String room_num) {
		String sql2 = "select price from room where room_num=? ;";
		String[] info2 = { room_num};
		ResultSet rs = JDBCUtil.executeQuery(sql2, info2);

		try {
				rs.next() ;
				return rs.getDouble("price");
			

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return 0;// 如果没有这个人则返回null
	}
}
