package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import pool.DBConstant;
public class Oracle implements Database{
	@Override
	public Connection getConnection() {
		Connection conn = null;
		try {
				Class.forName(DBConstant.ORACLE_DRIVER);
				conn = DriverManager.getConnection(
						DBConstant.CONNECTION_URL,
						DBConstant.UID,
						DBConstant.PWD);		
				//stmt = conn.createStatement();
		} catch (Exception e) {
				e.printStackTrace();
		} 
		return conn;
	}
}
