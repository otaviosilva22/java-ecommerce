package br.com.ifsuldeminas.saleproject.saleProduct;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface ISaleProductRepository extends JpaRepository<SaleProductModel, UUID> {
    
    @Query("SELECT sp FROM tb_saleproduct sp WHERE sp.id = :id")
    SaleProductModel findByIdSaleProduct(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query("DELETE FROM tb_saleproduct sp WHERE sp.id = :id")
    void deleteByIdSaleProduct(@Param("id") UUID id);
}
