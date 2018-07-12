package service;

import java.util.List;
import domain.*;

public interface MemberService {
		public boolean login(MemberBean member);
		public void createMember(MemberBean member);
		public List<MemberBean> findList();
		public List<MemberBean> findByName(String name);
		public MemberBean findByID(String id);
		public int countMember();
		public void updateMember(MemberBean member);
		public void deleteMember(MemberBean member);
	}
