package com.hefshine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hefshine.model.Cart;
import com.hefshine.projection.CartUi;

public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	int countByProductidAndUserid(int productid,int userid);
	
	@Query(value="SELECT * FROM Product p join Cart c on p.id=c.productid where c.userid=?" ,nativeQuery = true)
	List<CartUi> getAllProductsByProductid(int userid);
	
	

}
