package com.hefshine.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hefshine.model.Myorder;

public interface MyorderRepo extends JpaRepository<Myorder, Integer>{

}
