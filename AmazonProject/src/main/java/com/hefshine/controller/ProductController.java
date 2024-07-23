package com.hefshine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.model.Product;
import com.hefshine.projection.ProductUi;
import com.hefshine.repo.ProductRepo;

@RestController
@CrossOrigin()
@RequestMapping("seller")
public class ProductController {

	@Autowired
	ProductRepo productRepo;
	
	@RequestMapping("addNewProduct")
	public Product addnewProduct(@RequestBody Product obj)
	{
		return productRepo.save(obj);
	}
	
	@RequestMapping("getAllProducts{userid}")
	public List<ProductUi> allProducts(@PathVariable int userid)
	{
		return productRepo.getAllProducts(userid);
	}
	
}
