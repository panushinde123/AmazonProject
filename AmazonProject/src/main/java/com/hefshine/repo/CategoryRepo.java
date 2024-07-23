package com.hefshine.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hefshine.model.Category;
import com.hefshine.projection.CategoryUi;
import com.hefshine.projection.ProductUi;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
