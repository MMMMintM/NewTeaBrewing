package cn.edu.guet.zt.statistics.Service.impl;

import cn.edu.guet.zt.statistics.Dao.SearchDao;
import cn.edu.guet.zt.statistics.Dao.impl.SearchDaoImpl;
import cn.edu.guet.zt.statistics.Service.SearchService;
import cn.edu.guet.zt.statistics.util.SalesConnectionHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class SearchServiceImpl implements SearchService {
    @Override
    public void newSearch(String ID,String name){
        Connection conn = null;
        try {
            conn = SalesConnectionHandler.getConnection();

            SearchDao searchDao = new SearchDaoImpl();

            //开启事务
            conn.setAutoCommit(false);

            searchDao.newSearch(ID,name);

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("事务回滚");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }finally {
                SalesConnectionHandler.closeConnection();
            }
        }
    }

}
