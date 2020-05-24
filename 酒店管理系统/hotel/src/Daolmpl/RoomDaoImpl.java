package Daolmpl;
import java.sql.SQLException;
import java.util.List;
import javabean.Room;
import javabean.pageResult;
public interface RoomDaoImpl {
	List<Room> findAll();
	Room findByRoom(Room room);
	Room findByRoom(String room);
	public pageResult<Room> find_room_bypage(int page) throws SQLException;
	public int re_room_is_empty1(String room_num);
	public int re_room_is_empty2(String room_num);
	public double find_price_Room(String room_num);
	}

