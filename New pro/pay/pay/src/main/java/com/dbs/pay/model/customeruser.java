package com.dbs.pay.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customeruser")
public class customeruser {
		
	
	@Column(length=100)
	private String username;
	@Column(length=11)
	@Id
	private Long userid;
	@Column(length=100)
	private String userpassword;
	
	public customeruser() {
	}

	public customeruser(String username, Long userid, String userpassword) {
		super();
		this.username = username;
		this.userid = userid;
		this.userpassword = userpassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userid, username, userpassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		customeruser other = (customeruser) obj;
		return Objects.equals(userid, other.userid) && Objects.equals(username, other.username)
				&& Objects.equals(userpassword, other.userpassword);
	}

	@Override
	public String toString() {
		return "customeruser [username=" + username + ", userid=" + userid + ", userpassword=" + userpassword + "]";
	}
	
}