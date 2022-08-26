package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{

    List<Product> findAll();
    @Query("Select p From ProductType p")
    List<ProductType> findAllProductTypes();
    Optional<Product> findById(int id);
    Product findByName(String name);
    @Query("Select p From ProductType p where p.name = :name")
    ProductType getProductType(String name);
    Product save(Product p);
    @Query("Select p From Product p where p.price < :price")
    List<Product> findByPriceLessThan(double price);
}
