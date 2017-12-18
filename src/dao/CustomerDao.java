package dao;

import model.Book;
import model.Customer;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/11/6.
 */
public class CustomerDao {
	public int addCustomer(Connection con, Customer customer) throws SQLException {
		String sql = "insert into tb_customer (Customer_name, Customer_password, Customer_phone) values (?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		//statement.setString(1, customer.getId());
		statement.setString(1, customer.getName());
		statement.setString(2, customer.getPassword());
		statement.setInt(3, customer.getPhoneNum());
		return statement.executeUpdate();
	}
	//根据用户名来查询
	public Customer getCustomerByName(Connection con, String name){
		Customer customer = null;
		try {
			String sql = "select * from tb_customer where Customer_name = '"+name+"'";
			Statement statement = con.createStatement();
			ResultSet resultSet =  statement.executeQuery(sql);
			if (resultSet.next()) {
			    customer = new Customer();
				customer.setId(resultSet.getInt("Customer_id"));
				customer.setName(resultSet.getString("Customer_name"));
				customer.setPassword(resultSet.getString("Customer_password"));
				customer.setAddress(resultSet.getString("Customer_address_id"));
				customer.setOrderID(resultSet.getInt("Customer_order_id"));
				//customer.setCartID(resultSet.getInt("Cart_customer_id"));
				customer.setPhoneNum(resultSet.getInt("Customer_phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeCon(con);
		}
		return customer;
	}
	//根据用户名获取购物车集合
	public List<Book> getCartListByName(Connection con, String name){
		Statement statement = null;
		ResultSet set = null;
		List<Book> books = new java.util.ArrayList<Book>();
		String sql = "SELECT * FROM tb_book,tb_cart,tb_customer WHERE tb_customer.customer_name = '"+name+"' AND "
				+ "tb_customer.customer_id = tb_cart.cart_customer_id AND "
				+ "tb_cart.cart_book_id = tb_book.book_id";
		try {
			statement = con.createStatement();
			set = statement.executeQuery(sql);
			while(set.next()){
				Book book = new Book();
				book.setId(set.getInt("book_id"));
				book.setDescrible(set.getString("book_describe"));
				book.setDiscount(set.getFloat("book_discount"));
				book.setName(set.getString("book_name"));
				book.setPrice(set.getFloat("book_price"));
				book.setQuantity(set.getInt("Book_quantity"));
				book.setType(set.getInt("book_typeid"));
				books.add(book);
			}
			return books;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con);
		}
		return books;
	}
	public void closeCon(Connection con){
		if (con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public ArrayList<Customer> getCustomers() throws SQLException, ClassNotFoundException {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		DbUtil util = new DbUtil();
		Connection con = null;
		String sql = "select * from tb_customer";
			try {
				con = util.getCon();
				Statement statement = con.createStatement();
				ResultSet set = statement.executeQuery(sql);
				while (set.next()) {
					Customer customer = new Customer();
					customer.setId(set.getInt("Customer_id"));
					customer.setName(set.getString("Customer_name"));
					customer.setPassword(set.getString("Customer_password"));
					customer.setPhoneNum(set.getInt("Customer_phone"));
					customer.setAddress(set.getString("Customer_address_id"));
					customer.setOrderID(set.getInt("Customer_order_id"));
					customerList.add(customer);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		return customerList;
	}
	//
	public List<Customer> getUserList(int start, int number){
		String sql = "SELECT * FROM tb_customer LIMIT "+start+","+number+";";
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		DbUtil util = new DbUtil();
		Connection con = null;
			try {
				con = util.getCon();
				Statement statement = con.createStatement();
				ResultSet set = statement.executeQuery(sql);
				while (set.next()) {
					Customer customer = new Customer();
					customer.setId(set.getInt("Customer_id"));
					customer.setName(set.getString("Customer_name"));
					customer.setPassword(set.getString("Customer_password"));
					customer.setPhoneNum(set.getInt("Customer_phone"));
					customer.setAddress(set.getString("Customer_address_id"));
					customer.setOrderID(set.getInt("Customer_order_id"));
					customerList.add(customer);
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		return customerList;
	}
	
	//模糊查
	public ResultSet searchCustomerByName(Connection con, String name){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String sql = "SELECT customer_id,customer_name,customer_phone,customer_address_id "
				+ "FROM tb_customer where customer_name LIKE '%"+name+"%'";
		ResultSet set = null;	
		try {
				Statement statement = con.createStatement();
				set = statement.executeQuery(sql);
				
			}catch (Exception e){
				e.printStackTrace();
			}
		return set;
	}
	
	public ResultSet searchCustomerByNUm(Connection con,int num){
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String sql = "SELECT customer_id,customer_name,customer_phone,customer_address_id "
				+ "FROM tb_customer where customer_phone LIKE '%"+num+"%'";
		ResultSet set = null;	
		try {
				Statement statement = con.createStatement();
				 set = statement.executeQuery(sql);
				
			}catch (Exception e){
				e.printStackTrace();
			}
		return set;
	}
    public ResultSet getUserResultSet(int start,int number){
		String sql = "SELECT * FROM tb_customer LIMIT "+start+","+number+";";
		DbUtil util = new DbUtil();
		ResultSet set = null;
		Connection con = null;
			try {
				con = util.getCon();
				Statement statement = con.createStatement();
				 set = statement.executeQuery(sql);
			}catch (Exception e){
				e.printStackTrace();
			}
		return set;
	}
	//删除  
	public int deleteCustomer(int customerId){
		   String sql = "DELETE FROM tb_customer WHERE  customer_id = "+customerId+"";
		   	util.DbUtil dbUtil = new util.DbUtil();
		   	Connection connection = null;
		   	int count = 0;
		   	try {
					connection = dbUtil.getCon();
					java.sql.Statement statement = connection.createStatement();
					 count = statement.executeUpdate(sql);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					try {
						dbUtil.closeCon(connection);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		   	   return count;
	   }
	//修改
	public int modifyCustomer(Customer customer){
		 String sql = "update tb_customer set customer_name = '"+customer.getName()+"' , customer_phone = "+customer.getPhoneNum()+", customer_address_id  = '"+customer.getAddress()+"'"
		 		+ "where customer_id = "+customer.getId()+";";
	   	util.DbUtil dbUtil = new util.DbUtil();
	   	Connection connection = null;
	   	int count = 0;
	   	try {
				connection = dbUtil.getCon();
				java.sql.Statement statement = connection.createStatement();
				 count = statement.executeUpdate(sql);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					dbUtil.closeCon(connection);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	   	   return count;
	   }
	//测试sql
 	public static void main(String[] args)  {
		util.DbUtil dbUtil = new util.DbUtil();
		CustomerDao dao = new CustomerDao();
		List<Customer> customers = dao.getUserList(1, 3);
		System.out.println(customers.get(1).getName());
	}
}
