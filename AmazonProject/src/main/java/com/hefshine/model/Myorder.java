package com.hefshine.model;

import java.util.Date;

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
public class Myorder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	double amount;
	int userid;
	Date date;

}
