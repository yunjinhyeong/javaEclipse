package java0923;

import java.sql.Timestamp;

public class MemberVo {
	private int id;
	private String passwd;
	private String name;
	private Timestamp reg_date;
	
	public MemberVo() {
		super();
	}
	
	public MemberVo(int id, String passwd, String name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	 * @return the reg_date
	 */
	public Timestamp getReg_date() {
		return reg_date;
	}
	/**
	 * @param reg_date the reg_date to set
	 */
	public void setReg_date(Timestamp reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", reg_date=" + reg_date + "]";
	}
	
	
	
	
}
