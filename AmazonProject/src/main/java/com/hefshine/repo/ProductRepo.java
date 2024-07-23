package com.hefshine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hefshine.model.Product;
import com.hefshine.projection.ProductUi;
import com.hefshine.projection.ProductuiBuyer;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
//	List<Product> findByUserId(int userid);
	
	@Query(value="SELECT p.id,p.name,p.price,p.description,p.discount,p.rating,p.quantity,c.name "
			+ "as cname FROM  product p join category c on p.categoryid=c.id;",nativeQuery = true)
	List<ProductUi> getAllProducts(int userid);
	
	
	@Query(value="select id,name,price,description,discount,rating,quantity,datediff(now(),date) as days from product where categoryid=?1 and price>=?2 and price<=?3 and rating>=?4 ",nativeQuery = true)
	List<ProductuiBuyer> getProductsByFilter(int categoryid,int minprice,int maxprice,int minrating);


	

}
