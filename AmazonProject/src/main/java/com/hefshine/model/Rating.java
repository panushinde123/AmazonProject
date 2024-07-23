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

@Entity@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int userid;
	int productid;
	Date date;
	int stars;

}
