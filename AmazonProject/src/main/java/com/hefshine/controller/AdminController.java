package com.hefshine.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.model.Category;
import com.hefshine.projection.CategoryUi;
import com.hefshine.repo.CategoryRepo;

@RestController
@CrossOrigin()
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	CategoryRepo categoryRepo;
	
	
	@RequestMapping("getAll")
	public List<Category> allcategories()
	{
		return categoryRepo.findAll();
	}
	
	@RequestMapping("addNew{userid}")
	public Category addNewCategory(@PathVariable int userid, @RequestBody String name)
	{
		Category c=new Category();
		c.setDate(new Date());
		c.setName(name);
		c.setUserid(userid);
		
		return categoryRepo.save(c);
	}

}
