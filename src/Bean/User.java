package Bean;

public class User {
	// Integer 初值是 null, 表示不會篩出資料
	private Integer id;
	private String account;
	private String pwd;
	
	public Integer getId() {
		return id;
	}
	public String getAccount() {
		return account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
