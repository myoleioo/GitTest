package com.example.demo.repository;

import com.example.demo.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query("select u from UserEntity u where u.status<>true")
    public List<UserEntity> showAllUsers();

    @Modifying @Transactional
    @Query("update UserEntity u set u.status=true where u.id=:id")
    public void deleteUser(Integer id);

    public UserEntity findByEmail(String email);
}
