package spms.jdbc;

public class MemberDAO {
	private int SEQ;
	private String Email;
	private String Pwd;
	private String NName;
	private String RegDate;
	private String ModDate;
	public int getSEQ() {
		return SEQ;
	}
	public void setSEQ(int sEQ) {
		SEQ = sEQ;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public String getNName() {
		return NName;
	}
	public void setNName(String nName) {
		NName = nName;
	}
	public String getRegDate() {
		return RegDate;
	}
	public void setRegDate(String regDate) {
		RegDate = regDate;
	}
	public String getModDate() {
		return ModDate;
	}
	public void setModDate(String modDate) {
		ModDate = modDate;
	}
	
	
}
