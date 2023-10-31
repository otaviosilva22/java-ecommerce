package br.com.ifsuldeminas.saleproject.sale;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ISaleRepository extends JpaRepository<SaleModel, UUID> {
    
    @Query("SELECT p FROM tb_sale p WHERE p.userId = :id")
    List<SaleModel> findByIdUser(@Param("id") UUID id);

    @Query("SELECT p from tb_sale p WHERE p.id = :id")
    SaleModel findByIdSale(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query("DELETE FROM tb_sale p WHERE p.id = :id")
    void deleteByIdSale(@Param("id") UUID id);
}
