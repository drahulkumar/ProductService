package com.rahul.productservice.repositories;

import com.rahul.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {



    Optional<Category> findByName(String name);
    Category save(Category category);

//    List<Category> findByIdGreaterThanAndNameGreaterThan(Long id , String name);

}
