package service;

import java.util.List;

import dao.*;
import domain.*;

public class MemberServiceImpl implements MemberService{
	public static MemberService getInstance() {return instance;}
	public static MemberService instance = new MemberServiceImpl();
	public MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberBean> findList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean findByID(String id) {
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
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
}
