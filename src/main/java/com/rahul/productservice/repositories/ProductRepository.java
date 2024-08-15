package com.rahul.productservice.repositories;

import com.rahul.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {


    // Update is also done using update only
    // if the product has an id:
    // JPA will see if product with that id exist:
    // if no --> insert
    // if yes --> Update
    @Override
    Product save(Product p);

    @Override
    void delete(Product entity);

    List<Product> findAll();
    Optional<Product> findById(Long id);


}
