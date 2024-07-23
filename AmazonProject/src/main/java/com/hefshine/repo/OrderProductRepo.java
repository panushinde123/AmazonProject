package com.hefshine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.model.Orderproduct;

public interface OrderProductRepo extends JpaRepository<Orderproduct, Integer> {

}
