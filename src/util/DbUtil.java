package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/11/6.
 */
public class DbUtil {
    private String dbUrl = "jdbc:mysql://localhost:3306/db_BookShopping";
    private String dbUserName = "root";
    private String dbPassword = "104207";
    private String jdbcName = "com.mysql.jdbc.Driver";



    public Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        //要是这里报错了 极大的可能是密码错了
        return con;
    }

    public void closeCon(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
