package com.hefshine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity@Setter@Getter@ToString@NoArgsConstructor@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String username;
	String password;
	int accountType; //1-Admin  2-Seller 3-Buyer
	
	
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	
//	public void setAccountType(int accountType) {
//		this.accountType = accountType;
//	}
//	public Object getPassword() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	public int getId() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	public int getAccountType() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	
	
	

}
