package cn.edu.guet.sjl.util;

import javax.swing.table.DefaultTableModel;

public class ResetTable {
    /**
     * 此类用于重置Table
     */

    public static DefaultTableModel reset(Object[][] objects,String[] head){
        DefaultTableModel tableModel = new DefaultTableModel(objects,head){
            public boolean isCellEditable(int row,int colume){
                return false;
            }
        };
        return tableModel;
    }
}
