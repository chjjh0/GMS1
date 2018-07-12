package test;

import java.util.*;

import com.sun.xml.internal.ws.server.ServiceDefinitionImpl;

import dao.*;
import service.MemberServiceImpl;
public class Test {
public static void main(String[] args) {
	List<String> list = TestDAO.getInstance().getAge();
	System.out.println(MemberDAOImpl.getInstance().selectMemberList().get(1).getName());
	/*age 를 몇년생인지 추출
	1998년생 남자
	980000-1
	98+00+00+1
	980504-1*/
}
}
