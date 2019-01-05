package dataaccsesshelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Truong Dang
 */
public class DataAccsessHelper {

    protected Connection con;
    String HostName = "localhost";
    String port = "1433";
    String dbName = "QLNV";
    String user = "sa";
    String pass = "123456";
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String URL = "jdbc:sqlserver://" + HostName + ":" + port + ";databaseName=" + dbName + "";
//    jdbc:sqlserver://localhost:1113;databaseName=QLSVXX

    public void getConnection() {

        try {
            Class.forName(driver);
            try {
                con = DriverManager.getConnection(URL,user,pass);
            } catch (SQLException ex) {
                Logger.getLogger(DataAccsessHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataAccsessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getClose() {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataAccsessHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

	public void getUpDate() {
		// TODO Auto-generated method stub
		
	}
}
