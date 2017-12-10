package dao;

import model.Manager;
import util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lenovo on 2017/12/2.
 */
public class ManagerDao {
    public boolean isManager(Connection connection, Manager manager) throws SQLException {
        String sql = "select * from tb_manager where Manager_name = ? and Manager_pass = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, manager.getName());
            pstmt.setString(2, manager.getPassword());

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    public int setManager( Manager manager, Manager oldManager) throws SQLException, ClassNotFoundException {
        //String sql = "update tb_manager set Manager_name = ? and Manager_pass = ? where Manager_name = ?";
        //注意SQL语法，update不能用and
        String sql = "update tb_manager set Manager_name = ?, Manager_pass = ? where Manager_name = ?";
        DbUtil util = new DbUtil();
        Connection connection = util.getCon();
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, manager.getName());
            pstm.setString(2, manager.getPassword());
            pstm.setString(3, oldManager.getName());

            return pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            util.closeCon(connection);
        }
        return 0;
    }
}
