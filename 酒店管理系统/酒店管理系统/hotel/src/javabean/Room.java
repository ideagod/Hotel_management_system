package javabean;

public class Room {
	private String type;
	private String is_empty;
	private String room_num;
	private double price;
	private String img;
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getRoom_num() {
		return room_num;
	}
	public void setRoom_num(String room_num) {
		this.room_num = room_num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getIs_empty() {
		return is_empty;
	}
	public void setIs_empty(String is_empty) {
		this.is_empty = is_empty;
	}
}
