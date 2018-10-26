package cafe.jjdev.mall.service;

public class Member {
	private String id;
	private String pw;
	private int level;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		System.out.println(id+"<--id setId Member.java");
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		System.out.println(pw+"<--pw setPw Member.java");
		this.pw = pw;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		System.out.println(level+"<--level setLevel Member.java");
		this.level = level;
	}
	
}
