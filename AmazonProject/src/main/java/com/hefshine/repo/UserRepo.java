package com.hefshine.repo;
import org.springframework.data.jpa.repository.JpaRepository;


import com.hefshine.model.User;
public interface UserRepo extends JpaRepository<User, Integer> 
{	
	int countByUsername(String username);
	User findByUsername(String username);
}
