package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import model.Book;
import model.BookClass;

public class BookDao {
    //获取图书分类
    public List<BookClass> getBookClass(){
        util.DbUtil dbUtil = new util.DbUtil();
        Connection conn = null;
        List<BookClass> bookClasses = new java.util.ArrayList<>();
        try {
            conn = dbUtil.getCon();
            java.sql.Statement statement = conn.createStatement();
            String sql = "SELECT * FROM tb_booktype;";
            ResultSet resultSet  = statement.executeQuery(sql);

            while(resultSet.next()){
                BookClass bookClass = new BookClass();
                bookClass.setId(resultSet.getInt("id"));
                bookClass.setBookClass(resultSet.getString("type"));
                bookClass.setBookClassParam(resultSet.getString("param"));
                bookClasses.add(bookClass);
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                dbUtil.closeCon(conn);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bookClasses;
    }
    //插入书类  书类名字段约束是unique 利用异常来处理书类重复插入
    public int insertBookClass(String bookClass){
    	String sql = "INSERT INTO `db_bookshopping`.`tb_booktype` (type, param) VALUES ('"+bookClass+"','"+bookClass+"')";
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
    
    public int modifyBookClass(String bookClass,int bookId){
	 String sql = "update tb_booktype set type = '"+bookClass+"' where id = "+bookId+";";
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
   
    public int deleteBookClass(int bookId){
	   String sql = "DELETE FROM tb_booktype where  id = "+bookId+"";
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

    //获取一种书类的前几本书  返回一个集合
    public List<model.Book> getBookListById(int id){
   	String sql = "SELECT * FROM db_bookshopping.tb_book where book_typeid = "+id+" limit 0,5 ;";
   	util.DbUtil dbUtil = new util.DbUtil();
   	Connection connection = null;
   	List<model.Book> list = new java.util.ArrayList<model.Book>();
   	try {
			connection = dbUtil.getCon();
			java.sql.Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while(set.next()){
				Book book = new model.Book();
				book.setAuthor(set.getString("book_author"));
				book.setDescrible(set.getString("book_describe"));
				book.setDiscount(set.getFloat("book_discount"));
				book.setId(set.getInt("book_id"));
				book.setName(set.getString("book_name"));
				book.setType(set.getInt("book_typeid"));
				book.setPrice(set.getFloat("book_price"));
				book.setQuantity(set.getInt("book_quantity"));
				book.setUrl(set.getString("book_url"));
				list.add(book);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	return list;

   }
	
	public List<model.Book> getBookListByType(BookClass bookClass) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM db_bookshopping.tb_book where book_typeid = " + bookClass.getId();
		util.DbUtil dbUtil = new util.DbUtil();
		Connection connection = null;
		List<model.Book> list = new java.util.ArrayList<model.Book>();

		Connection con = dbUtil.getCon();
		PreparedStatement statement = con.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Book book = new Book();
			book.setId(resultSet.getInt("Book_id"));
			book.setName(resultSet.getString("Book_name"));
			book.setPrice(resultSet.getFloat("Book_price"));
			book.setDiscount(resultSet.getFloat("Book_discount"));
			book.setType(resultSet.getInt("Book_typeid"));
			book.setDescrible(resultSet.getString("Book_describe"));
			book.setQuantity(resultSet.getInt("Book_quantity"));
			book.setUrl(resultSet.getString("Book_url"));
			book.setAuthor(resultSet.getString("Book_author"));
		//		System.out.println("getTYpe��" + book.getType());
			list.add(book);
		}
		return list;

	}
	
    public Map<String, List<Book>> getAllBooks(){
		BookDao dao = new BookDao();
		List<BookClass> bookClassList =  dao.getBookClass();

		Map<String, List<Book>> books = new HashMap<>();

		for(BookClass type : bookClassList){
			try {
				List<model.Book> bookList = dao.getBookListByType(type);
				books.put(type.getBookClass(), bookList);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return books;
	}

    //根据作者查询
    public List<Book> searchBookByAuthor(String author){
 	   String sql = "SELECT * FROM db_bookshopping.tb_book WHERE book_author LIKE '%"+author+"%'";
 	   util.DbUtil dbUtil = new util.DbUtil();
 	   Connection connection = null;
 	   List<Book> list = new java.util.ArrayList();
 	   try {
 		 connection = dbUtil.getCon();
 		 java.sql.Statement statement = connection.createStatement();
 		 ResultSet set =  statement.executeQuery(sql);
 		 while(set.next()){
 			 Book book = new model.Book();
 				book.setAuthor(set.getString("book_author"));
 				book.setDescrible(set.getString("book_describe"));
 				book.setDiscount(set.getFloat("book_discount"));
 				book.setId(set.getInt("book_id"));
 				book.setName(set.getString("book_name"));
 				book.setType(set.getInt("book_typeid"));
 				book.setPrice(set.getFloat("book_price"));
 				book.setQuantity(set.getInt("book_quantity"));
 				book.setUrl(set.getString("book_url"));
 				list.add(book);
 		 }
 	} catch (ClassNotFoundException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	} catch (SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}finally{
 		try {
 			dbUtil.closeCon(connection);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
 	   return list;
    }
    
    //更具书名查询 不精确匹配
    public List<Book> searchBookByName(String bookName){
 	   String sql = "SELECT * FROM db_bookshopping.tb_book where book_name LIKE '%"+bookName+"%'";
 	   util.DbUtil dbUtil = new util.DbUtil();
 	   Connection connection = null;
 	   List<Book> list = new java.util.ArrayList();
 	   try {
 		 connection = dbUtil.getCon();
 		 java.sql.Statement statement = connection.createStatement();
 		 ResultSet set =  statement.executeQuery(sql);
 		 while(set.next()){
 			 Book book = new model.Book();
 				book.setAuthor(set.getString("book_author"));
 				book.setDescrible(set.getString("book_describe"));
 				book.setDiscount(set.getFloat("book_discount"));
 				book.setId(set.getInt("book_id"));
 				book.setName(set.getString("book_name"));
 				book.setType(set.getInt("book_typeid"));
 				book.setPrice(set.getFloat("book_price"));
 				book.setQuantity(set.getInt("book_quantity"));
 				book.setUrl(set.getString("book_url"));
 				list.add(book);
 		 }
 	} catch (ClassNotFoundException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	} catch (SQLException e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 	}finally{
 		try {
 			dbUtil.closeCon(connection);
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 	}
 	   return list;
    }

   //for testing
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
		BookDao dao = new BookDao();
		List<Book> books = dao.searchBookByAuthor("贾平");
		System.out.println(books);

		




	}

}
