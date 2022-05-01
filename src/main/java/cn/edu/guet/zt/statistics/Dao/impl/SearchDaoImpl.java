package cn.edu.guet.zt.statistics.Dao.impl;

import cn.edu.guet.zt.statistics.Dao.SearchDao;
import cn.edu.guet.zt.statistics.util.SalesConnectionHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SearchDaoImpl implements SearchDao {
    @Override
    public void newSearch(String ID,String name){
        Connection conn = null;
        try {
            conn = SalesConnectionHandler.getConnection();

            String sql = "SELECT * FROM sales_volume WHERE INSTR(id,\\'?\\')<>0 AND INSTR(title,\\'?\\') <> 0;";

            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,ID);
            pstmt.setString(2,name);

            pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
