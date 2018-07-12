package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class TestDAO {
public static TestDAO getInstance() {return instance;};
public static TestDAO instance = new TestDAO();
public TestDAO() {}

public List<String> getAge() {
	List<String> list = new ArrayList<>();
	list.add("a");
	
	
	
	/*Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "chjjh0", "c1c2");
	Statement stmt = conn.createStatement();
	String sql = String.format(
			"SELECT * FROM MEMBER"
			+ "WHERE MEMID LIKE '%S'"
			+ "AND PASSWORD LIKE '%S'"
			, member.getUserid(), member.getPassword());
	System.out.println("sql" + sql);
	ResultSet rs = stmt.executeQuery(sql);*/
	
return list;	
} 

}
