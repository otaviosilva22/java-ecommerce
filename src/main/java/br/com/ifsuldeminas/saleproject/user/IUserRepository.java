package br.com.ifsuldeminas.saleproject.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface IUserRepository extends JpaRepository<UserModel, UUID>{
        
    @Query("SELECT u FROM tb_users u WHERE u.id = :id")
    UserModel findByUserId(@Param("id") UUID id);

    @Modifying
    @Transactional
    @Query("DELETE FROM tb_users u WHERE u.id = :id")
    void deleteByUserId(@Param("id") UUID id);
}