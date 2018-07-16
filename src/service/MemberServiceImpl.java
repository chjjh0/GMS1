package service;

import java.util.ArrayList;
import java.util.List;
import dao.*;
import domain.*;

public class MemberServiceImpl implements MemberService{
	public static MemberService getInstance() {return instance;}
	private static MemberService instance = new MemberServiceImpl();
	private MemberServiceImpl() {}
	@Override
	public void createMember(MemberBean member) {
		MemberDAOImpl.getInstance().insertMember(member);
	}

	@Override
	public List<MemberBean> findList() {
		return MemberDAOImpl.getInstance().selectMemberList();
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectMemberByName(name);
	}

	@Override
	public MemberBean findByID(String id) {
		return MemberDAOImpl.getInstance().selectMemberByID(id);
	}

	@Override
	public int countMember() {
		return 0;
	}

	@Override
	public void updateMember(MemberBean member) {
		MemberDAOImpl.getInstance().updateMember(member);		
	}

	@Override
	public void deleteMember(MemberBean member) {
		MemberDAOImpl.getInstance().deleteMember(member);
	}
	@Override
	public boolean login(MemberBean member) {
		return (MemberDAOImpl.getInstance().login(member)!=null);
	}
}
