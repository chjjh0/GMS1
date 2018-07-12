package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import pool.DBConstant;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() {return instance;}
	public static MemberDAO instance = new MemberDAOImpl();
	Connection conn;
	Statement stmt;
	
	public MemberDAOImpl() {
		try{
			Class.forName(DBConstant.ORACLE_DRIVER);
			conn = DriverManager.getConnection(
					DBConstant.CONNECTION_URL,
					DBConstant.UID,
					DBConstant.PWD				
				);
			stmt = conn.createStatement();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void insertMember(MemberBean member) {
		
	}
	@Override
	public List<MemberBean> selectMemberList() {
		MemberBean m = null;
		List<MemberBean> mList = new ArrayList<>();
		String sql = String.format(
				" SELECT * FROM MEMBER ");
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				m = new MemberBean();
				m.setUserid(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setSsn("AGE");
				m.setRoll("ROLL");
				m.setPassword("PASSWORD");
				mList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(m.toString());		
		return mList;
	}
	@Override
	public List<MemberBean> selectMemberByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public MemberBean selectMemberByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countMember() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {
			Class.forName(DBConstant.ORACLE_DRIVER);
			Connection conn = DriverManager.getConnection
					(DBConstant.CONNECTION_URL,
					 DBConstant.UID,
					 DBConstant.PWD);
			Statement stmt = conn.createStatement();
			String sql = String.format(
					"SELECT MEMID, "
							+" TEAMID, "
							+" NAME, "
							+" ROLL, "
							+" PASSWORD "
							+" SSN "
							+" FROM MEMBER "
							+" WHERE MEMID LIKE '%s' "
							+" AND PASSWORD LIKE '%s' "
					, member.getUserid(), member.getPassword());
			System.out.println("sql" + sql);
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				mem = new MemberBean();
				mem.setUserid(rs.getString("MEMID"));
				mem.setTeamId(rs.getString("TEAMID"));
				mem.setName(rs.getString("NAME"));
				mem.setSsn(rs.getString("SSN"));
				mem.setRoll(rs.getString("ROLL"));
				System.out.println(rs.getString("NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mem;
	}
}
