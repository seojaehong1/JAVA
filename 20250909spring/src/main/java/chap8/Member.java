package chap8;

import java.time.LocalDateTime;

public class Member {

	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime regDate;
	public Member(Long id, String email, String password, String name, LocalDateTime regDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.regDate = regDate;
	}
	
	public Member() {}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", regDate="
				+ regDate + "]";
	}
	
	

	
	
	
	

//	public void changePassword(String oldPassword, String newPassword) {
//		if (!password.equals(oldPassword))
//			throw new WrongIdPasswordException();
//		this.password = newPassword;
//	}

}
