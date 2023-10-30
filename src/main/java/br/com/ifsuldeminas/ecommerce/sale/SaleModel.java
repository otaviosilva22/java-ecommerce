package br.com.ifsuldeminas.ecommerce.sale;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_sale")
public class SaleModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private double total;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
