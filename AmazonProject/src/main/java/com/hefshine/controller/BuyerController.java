package com.hefshine.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hefshine.model.Cart;
import com.hefshine.model.Myorder;
import com.hefshine.model.Orderproduct;
import com.hefshine.model.Product;
import com.hefshine.model.Rating;
import com.hefshine.projection.CartUi;
import com.hefshine.projection.ProductuiBuyer;
import com.hefshine.repo.CartRepo;
import com.hefshine.repo.MyorderRepo;
import com.hefshine.repo.OrderProductRepo;
import com.hefshine.repo.ProductRepo;
import com.hefshine.repo.RatingRepo;

import aj.org.objectweb.asm.commons.TryCatchBlockSorter;

@RestController
@CrossOrigin()
@RequestMapping("buyer")
public class BuyerController {
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	RatingRepo ratingRepo;
	
	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	MyorderRepo myorderRepo;
	
	@Autowired
	OrderProductRepo orderProductRepo;
	
	
	@RequestMapping("placeOrder{id}")
	public int placeOrder(@PathVariable int id,@RequestBody int[][] a)
	{
		try {
			
			Myorder order=new Myorder();
			order.setDate(new Date());
			order.setUserid(id);
			order=myorderRepo.save(order);
			
			double totalamount=0;
			for(int i=0;i<a.length;i++)
			{ 
				int[] a1=a[i];
				int cartid=a1[0];
				int quantity=a1[1];
				
				
				Cart cart=cartRepo.findById(cartid).get();
				int productid=cart.getProductid();
				Product product=productRepo.findById(productid).get();
				Orderproduct obj=new Orderproduct();
				
				double amount=product.getPrice()*quantity;
				amount=amount-(amount*product.getDiscount()/100);
				obj.setAmount(amount);
				
				totalamount+=amount;
				
				obj.setDate(new Date());
				obj.setOrderid(order.getId());
				obj.setProductid(productid);
				orderProductRepo.save(obj);
				
				cartRepo.delete(cart);
			}
			order.setAmount(totalamount);
			myorderRepo.save(order);
			
			
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	
	
	
	@DeleteMapping("deleteProduct{id}")
	public boolean deleteByid(@PathVariable("id") int id)
	{
		boolean status=false;
		if(id!=0)
		{
			cartRepo.deleteById(id);
			status=true;
		}
		return status;   
	}
	
	@RequestMapping("getAllProductsByUserid{userid}")
	public List<CartUi> getAllProductsByUserid(@PathVariable int userid)
	{
		try {
			return cartRepo.getAllProductsByProductid(userid);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;	
	}
	
	@RequestMapping("getByProductandUsers{productid}and{userid}")
	public int getByProductandUsers(@PathVariable int productid,@PathVariable int userid)
	{
		int count=cartRepo.countByProductidAndUserid(productid, userid);
		if(count==1)
			return 1;
		else if(count>1)
			return 0;
		else
			{
			Cart cart=new Cart();
			cart.setProductid(productid);
			cart.setUserid(userid);
			cartRepo.save(cart);
			return -1;
			}
	}
	
	@RequestMapping("getRating{productid}and{userid}and{stars}")
	public int getRating(@PathVariable int productid,@PathVariable int userid,@PathVariable int stars)
	{
		try {
			
			int count=ratingRepo.countByProductidAndUserid(productid, userid);
			
			if(count==1)
			{
				Rating rev=ratingRepo.findByProductidAndUserid(productid, userid);
				rev.setDate(new Date());
				rev.setStars(stars);
				ratingRepo.save(rev);
			}
			else if(count==0)
			{
				Rating r=new Rating();
				r.setProductid(productid);
				r.setUserid(userid);
				r.setDate(new Date());
				r.setStars(stars);
				ratingRepo.save(r);
			}
			else
				return 0;
			
			double avg=ratingRepo.getAvgByProductid(productid);
			Product product=productRepo.findById(productid).get();
			product.setRating(avg);
			productRepo.save(product);
			
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@RequestMapping("getProductsByFilters")
	public List<ProductuiBuyer> getProducts(@RequestBody int[] a)
	{
		return productRepo.getProductsByFilter(a[0],a[1],a[2],a[3]);
	}
}
