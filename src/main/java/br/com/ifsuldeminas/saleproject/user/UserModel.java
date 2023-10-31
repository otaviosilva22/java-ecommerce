package br.com.ifsuldeminas.saleproject.user;

import java.time.LocalDateTime;
import java.util.UUID;


import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "tb_users")
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    
    @Column(unique = true, nullable = false)
    private String username;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String password;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String address;

    @CreationTimestamp
    private LocalDateTime createdAt;
}