package domain;

public class MemberBean {


	@Override
	public String toString() {
		return "회원정보 [ssn=" + ssn + ", memId=" + memId + ", teamId=" + teamId + ", name=" + name + ", roll="
				+ roll + ", userid=" + userid + ", password=" + password + ", updatePassword=" + updatePassword
				+ ", getUpdatePassword()=" + getUpdatePassword() + ", getSsn()=" + getSsn() + ", getMemId()="
				+ getMemId() + ", getTeamId()=" + getTeamId() + ", getName()=" + getName() + ", getRoll()=" + getRoll()
				+ ", getUserid()=" + getUserid() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public String getUpdatePassword() {
		return updatePassword;
	}

	public void setUpdatePassword(String updatePassword) {
		this.updatePassword = updatePassword;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoll() {
		return roll;
	}

	public void setRoll(String roll) {
		this.roll = roll;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String ssn, memId, teamId, name, roll, userid, password, updatePassword;
	
}
