package com.hefshine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString@NoArgsConstructor@AllArgsConstructor
public class LoginReturn {
	
	
	int id;
	int accountType;
	String errorMsg;

}
