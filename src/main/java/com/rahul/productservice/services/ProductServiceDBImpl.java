package com.rahul.productservice.services;

import com.rahul.productservice.Exceptions.ProductNotFoundException;
import com.rahul.productservice.models.Category;
import com.rahul.productservice.models.Product;
import com.rahul.productservice.repositories.CategoryRepository;
import com.rahul.productservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    public ProductServiceDBImpl(ProductRepository productRepository , CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product createProduct(Product product) {
        Category toBePutInProduct = getCategoryToBeInProduct(product);
        product.setCategory(toBePutInProduct);

        Product savedProduct = productRepository.save(product);


        return savedProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public  Product partialUpdateProduct(Long productId , Product product) throws ProductNotFoundException {
        Optional<Product> productToUpdateOptional = productRepository.findById(productId);
        if(productToUpdateOptional.isEmpty()){
            throw new ProductNotFoundException();

        }

        Product productToUpdate = productToUpdateOptional.get();
        if(product.getDescription() !=null){
            productToUpdate.setDescription(product.getDescription());
        }

        if(product.getPrice()!=null){
            productToUpdate.setPrice(product.getPrice());
        }

        if(product.getTitle()!=null){
            productToUpdate.setTitle(product.getTitle());
        }
        if(product.getCategory().getName()!=null){
            Category toBePutInProduct = getCategoryToBeInProduct(product);
            productToUpdate.setCategory(toBePutInProduct);
        }
        return  productRepository.save(productToUpdate);
    }

    private Category getCategoryToBeInProduct(Product product) {
        String categoryName = product.getCategory().getName();

        Optional<Category> category = categoryRepository.findByName(categoryName);
        Category toBePutInProduct = null;

        if(category.isEmpty()){
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);

            toBePutInProduct = toSaveCategory;
                    //categoryRepository.save(toSaveCategory);
            // categoryRepository.save(toSaveCategory);
        }
        else{
            toBePutInProduct = category.get();
        }
        return toBePutInProduct;
    }

    @Override
    public Product getProductById(Long id) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }




//    @Override
//    public void createProduct(String title, String description, double price, String category, String imageUrl) {
//
//    }


}
