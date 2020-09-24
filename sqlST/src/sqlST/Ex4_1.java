package sqlST;

import java.sql.Timestamp;

public class Ex4_1 {
	// VO 데이터 베이스 테이블 구조와 보통 일치되게 설계함
	private int actorId;
	private String lastName;
	private String firstName;
	private Timestamp lastUpdate;
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public Timestamp getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	@Override
	public String toString() {
		return "Ex4_1 [actorId=" + actorId + ", lastName=" + lastName + ", firstName=" + firstName + ", lastUpdate="
				+ lastUpdate + ", toString()=" + super.toString() + "]";
	}
	
	
	// 단축키
	
	
	
	
	
}
