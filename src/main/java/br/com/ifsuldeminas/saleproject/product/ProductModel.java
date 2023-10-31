package br.com.ifsuldeminas.saleproject.product;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_product")
public class ProductModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private String lable;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer quantity;
    
    @Column(nullable = false)
    private double price;

    @CreationTimestamp
    private LocalDateTime createdAt;
}