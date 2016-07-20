package com.fweb.dto;

public class LoginDTO {
	private String mem_email;
	private String mem_pwd;
	private boolean useCookie;

	public LoginDTO() {
	}

	public LoginDTO(String mem_email, String mem_pwd) {
		this.mem_email = mem_email;
		this.mem_pwd = mem_pwd;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}

	@Override
	public String toString() {
		return "LoginDTO [mem_email=" + mem_email + ", mem_pwd=" + mem_pwd + ", useCookie=" + useCookie + "]";
	}

}
