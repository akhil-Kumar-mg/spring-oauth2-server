package com.caremanager.springsecurityoracledb.repository;

import com.caremanager.springsecurityoracledb.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query(value = "SELECT * FROM USERS WHERE NAME=?1", nativeQuery = true)
    Optional<Users> findByName(String username);


}
