package sqlST;

import java.sql.Timestamp;

public class testVo {
	private String id;
	private String passwd;
	private String name;
	private Timestamp reg_time; // timestamp ��¥ �ð� ������ �� �����Ҽ��ִ� ��ü
	// select current_timestamp(); �� MySQL���� ���� ��¥ �ð� �˼��ִ� ��ɾ� �ƽ��Ե� now() �� �ƴϴ�
	
	public testVo() {
		super();
	}
	
	public testVo(String id, String passwd, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the passwd
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * @param passwd the passwd to set
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the reg_time
	 */
	public Timestamp getReg_time() {
		return reg_time;
	}
	/**
	 * @param reg_time the reg_time to set
	 */
	public void setReg_time(Timestamp reg_time) {
		this.reg_time = reg_time;
	}
	@Override
	public String toString() {
		return "testVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", reg_time=" + reg_time + "]";
	}
	
	
	
}
