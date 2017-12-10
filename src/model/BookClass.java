package model;

public class BookClass {
	private int id;     
	private String bookClass;
	private String bookClassParam; //用于 传参的时候设置参数名
	
	public String getBookClassParam() {
		return bookClassParam;
	}
	public void setBookClassParam(String bookClassParam) {
		this.bookClassParam = bookClassParam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookClass() {
		return bookClass;
	}
	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}
	
}
