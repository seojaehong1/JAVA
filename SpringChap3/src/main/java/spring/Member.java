package spring;

import java.time.LocalDateTime;

import spring.WrongIdPasswordException;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDateTime;
	public Member(String email, String password, String name, LocalDateTime registerDateTime) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDateTime = registerDateTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public Member(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	
	
	
	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}
	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}
	public void changePassword(String oldPassword, String newPassword) {
		if(!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}
}
