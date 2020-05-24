package Daolmpl;
import java.sql.SQLException;
import java.util.List;
import javabean.customer;
import javabean.pageResult;

public interface CustomerDaoImpl {
	public int in_customer(customer cust);
	public int renew_room(int new_day,String room_num);
	public List<customer> select_customer(String customer_information);
	public pageResult<customer> select_customer_bypage(int page,String customer_information) throws SQLException;
	public pageResult<customer> find_customer_bypage(int page) throws SQLException;
	public int set_customer(customer cust);
	public customer select1_customer(String room_num);
	public int delete_customer(String room_num) ;
	public pageResult<customer> select_old_customer_bypage(int page,String customer_information) throws SQLException;
	public pageResult<customer> find_old_customer_bypage(int page) throws SQLException;
}

