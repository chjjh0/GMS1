package enums;

import domain.*;

public enum MemberQuery {
/* MEMID, TEAMID, NAME, AGE, ROLL, PASSWORD, SSN */
	LOGIN, INSERT_MEMBER, EXIST_ID,
	COUNT_MEMBER, UPDATE_MEMBER, DELETE_MEMBER,
	LIST, LISTBYONE, LISTBYSOME
	;
	@Override
	public String toString() {
		String query="";
		MemberBean member = new MemberBean();
		switch(this) {
		case LOGIN:
			query = String.format(
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
			break;
		case INSERT_MEMBER:
			query = String.format(
					" INSERT INTO MEMBER( "
					+" %s, "
					+" 99, "
					+" %s, "
					+" '99' "
					+" 'ROLL' "
					+" %s "
					+" %s "
					, member.getUserid(), member.getName()
					, member.getPassword()
					, member.getSsn()
					);
			break;
		case DELETE_MEMBER:
			query = " DELETE MEMBER "
					+ " WHERE NAME LIKE '%s' ";
			break;
		case EXIST_ID : 
			query = "SELECT MEMID "
					+ "FROM MEMBER "
					+ "WHERE MEMID LIKE '%s'";
			break;
		case COUNT_MEMBER :
			query = " SELECT COUNT(*) AS count FROM MEMBER ";
			break;
		case UPDATE_MEMBER :
			query = " UPDATE MEMBER SET PASSWORD = '%s' " 
					+ " WHERE MEMID LIKE '%s' "
					+ " AND PASSWORD <> '%s' ";
			break;
		case LIST :
			query = " SELECT * FROM MEMBER ";
			break;
		case LISTBYSOME :
			query = " SELECT NAME FROM MEMBER "
					+ " WHERE NAME LIKE '%s' ";
			break;
		case LISTBYONE :
			query = " SELECT MEMID FROM MEMBER "
					+ " WHERE MEMID LIKE '%s' ";
			break;
		}
		return query;
	} 
			
}
