package com.fweb.domain;

public class MemberVO {

	private String mem_email;
	private String mem_pwd;
	private String mem_name;

	private Integer mem_age;
	private Integer mem_sex;
	private Integer mem_weight;
	private Integer mem_diabetes;
	private Integer mem_obesity;
	private Integer mem_highblood;
	private Integer mem_hyper;

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

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public Integer getMem_age() {
		return mem_age;
	}

	public void setMem_age(Integer mem_age) {
		this.mem_age = mem_age;
	}

	public Integer getMem_sex() {
		return mem_sex;
	}

	public void setMem_sex(Integer mem_sex) {
		this.mem_sex = mem_sex;
	}

	public Integer getMem_weight() {
		return mem_weight;
	}

	public void setMem_weight(Integer mem_weight) {
		this.mem_weight = mem_weight;
	}

	public Integer getMem_diabetes() {
		return mem_diabetes;
	}

	public void setMem_diabetes(Integer mem_diabetes) {
		this.mem_diabetes = mem_diabetes;
	}

	public Integer getMem_obesity() {
		return mem_obesity;
	}

	public void setMem_obesity(Integer mem_obesity) {
		this.mem_obesity = mem_obesity;
	}

	public Integer getMem_highblood() {
		return mem_highblood;
	}

	public void setMem_highblood(Integer mem_highblood) {
		this.mem_highblood = mem_highblood;
	}

	public Integer getMem_hyper() {
		return mem_hyper;
	}

	public void setMem_hyper(Integer mem_hyper) {
		this.mem_hyper = mem_hyper;
	}

	@Override
	public String toString() {
		return "MemberVO [mem_email=" + mem_email + ", mem_pwd=" + mem_pwd + ", mem_name=" + mem_name + ", mem_age="
				+ mem_age + ", mem_sex=" + mem_sex + ", mem_weight=" + mem_weight + ", mem_diabetes=" + mem_diabetes
				+ ", mem_obesity=" + mem_obesity + ", mem_highblood=" + mem_highblood + ", mem_hyper=" + mem_hyper
				+ "]";
	}

}
