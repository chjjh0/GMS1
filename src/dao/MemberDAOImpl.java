package dao;

import java.sql.*;
import java.util.*;
import domain.*;
import enums.*;
import factory.*;
import pool.*;

public class MemberDAOImpl implements MemberDAO{
	public static MemberDAO getInstance() {return instance;}
	private static MemberDAO instance = new MemberDAOImpl();
	private MemberDAOImpl() {}
	Connection conn;
	Statement stmt;
	
	@Override
	public void insertMember(MemberBean member) {
		try{
		//excuteUpdate의 return 이 int 값이 돌아온다 성공:1 실패:0
		//return의 용도는 개발자의 디버깅용도이며
		//사용법은 DatabaseFactory 앞에 int a 로 받아주면 됨
		DatabaseFactory.createDataBase(
				Vendor.ORACLE,
				DBConstant.UID,
				DBConstant.PWD
				)
		.getConnection()
		.createStatement()
		.executeQuery("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<MemberBean> selectMemberList() {
		MemberBean m = null;
		List<MemberBean> mList = null;
		try {
			ResultSet rs = DatabaseFactory.createDataBase(
							Vendor.ORACLE,
							DBConstant.UID,
							DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.LIST.toString());
			mList = new ArrayList<>();
			while(rs.next()) {
				m = new MemberBean();
				m.setUserid(rs.getString("MEMID"));
				m.setTeamId(rs.getString("TEAMID"));
				m.setName(rs.getString("NAME"));
				m.setSsn(rs.getString("AGE"));
				m.setRoll(rs.getString("ROLL"));
				m.setPassword(rs.getString("PASSWORD"));
				mList.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mList;
	}
	@Override
	public List<MemberBean> selectMemberByName(String name) {
		MemberBean mem = null;
		List<MemberBean> mList = null;
		try {
			ResultSet rs = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD
					)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.LISTBYSOME.toString(),
					name));
			mList = new ArrayList<>();
			while(rs.next()) {
				mem = new MemberBean();
				mem.setName(rs.getString("NAME"));
				mList.add(mem);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
				return mList;
	}
	@Override
	public MemberBean selectMemberByID(String id) {
		MemberBean mem = null;
		try {
		ResultSet rs = DatabaseFactory.createDataBase(
				Vendor.ORACLE, 
				DBConstant.UID,
				DBConstant.PWD)
		.getConnection()
		.createStatement()
		.executeQuery(String.format(
				MemberQuery.LISTBYONE.toString(), 
				id));				
		while(rs.next()) {
			mem = new MemberBean();
			mem.setMemId(rs.getString("MEMID"));
		}	
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return mem;
	}
	@Override
	public int countMember() {
		try{
			ResultSet rs = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD
					)
			.getConnection()
			.createStatement()
			.executeQuery(MemberQuery.COUNT_MEMBER.toString());
			int count=0;
			while(rs.next()) {
				count = rs.getInt("count"); 
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return 0;
	}
	@Override
	public void updateMember(MemberBean member) {
		int rs=0;
		try {
			rs = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeUpdate(String.format(
					MemberQuery.UPDATE_MEMBER.toString(),
					member.getUpdatePassword(),
					member.getUserid(),
					member.getUpdatePassword()
					));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteMember(MemberBean member) {
		System.out.println(String.format(String.format(
					MemberQuery.DELETE_MEMBER.toString(),
					member.getName())));
		try {
			DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
			.getConnection()
			.createStatement()
			.executeQuery(String.format(
					MemberQuery.DELETE_MEMBER.toString(),
					member.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public String join(MemberBean member) {
		String result = "";
		try {	
			Statement stmt = DatabaseFactory.createDataBase(
					Vendor.ORACLE,
					DBConstant.UID,
					DBConstant.PWD)
					.getConnection()
					.createStatement();
			ResultSet rs = stmt.executeQuery(String.format(
					"SELECT MEMID MEMID "+
					"FROM MEMBER "+
					"WHERE MEMID LIKE '%s'"
					, member.getMemId()));
			if(rs.next()) {
				//아이디중복
				result ="아이디가 이미 있습니다.";
			}else {				
				stmt.execute(
						String.format(
						"INSERT INTO MEMBER "
						+ "(MEMID, NAME, SSN, PASSWORD, AGE) "
						+ "VALUES "
						+ "('%s','%s','%s','%s','%d')", 
						member.getMemId(),
						member.getName(),
						member.getSsn(),
						member.getPassword(),
						(119-Integer.parseInt(member.getSsn().substring(0, 2)))
						)
				);
				result = "등록 성공";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public MemberBean login(MemberBean member) {
		MemberBean mem = null;
		try {
			/*Class.forName(DBConstant.ORACLE_DRIVER);
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
			System.out.println("sql" + sql);*/
			ResultSet rs = stmt.executeQuery("");
			
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
