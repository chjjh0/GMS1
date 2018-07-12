package dao;

import java.util.List;
import domain.*;

public interface MemberDAO {
	public MemberBean login(MemberBean member);
	public void insertMember(MemberBean member);
	public List<MemberBean> selectMemberList();
	public List<MemberBean> selectMemberByName(String name);
	public MemberBean selectMemberByID(String id);
	public int countMember();
	public void updateMember(MemberBean member);
	public void deleteMember(MemberBean member);
}
