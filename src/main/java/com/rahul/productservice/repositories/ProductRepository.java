package com.rahul.productservice.repositories;

import com.rahul.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {

    //JPA Methods
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
    List<Product> findAllByCategory_Subcategories_SurnameEquals(String subcategories_Surname);



    //JPA Queries : work in terms of class names, not exactly in terms of SQL queries
    // Combination of SQL and JPA
    @Query("select p " +
            "from  Product p " +
            "where p.category.subcategories.surname= :categorySurname")
    List<Product> blal(@Param("categorySurname") String categorySurname);

    @Query("select p from Product  p where p.id > :idGreaterThan")
    List<Product> somethingSomething(@Param("idGreaterThan") Long idGreaterThan);


    //JPA Queries with native query(means exact SQL queries in terms of DP tables)
    @Query(
            value = CustomQueries.GET_PRODUCTS_WITH_SUBCATEGORY_NAME,
            nativeQuery=true
    )
    List<Product> something2();



}
