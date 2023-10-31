package br.com.ifsuldeminas.saleproject.product;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface IProductRepository extends JpaRepository<ProductModel, UUID>{

    @Query("SELECT p FROM tb_product p WHERE p.id = :id")
    ProductModel findByIdProduct(@Param("id") UUID id);
    
    @Modifying
    @Transactional
    @Query("DELETE FROM tb_product p WHERE p.id = :id")
    void deleteByIdProduct(@Param("id") UUID id);
}