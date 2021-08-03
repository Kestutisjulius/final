package com.java.bend.repository;

import com.java.bend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT c FROM User c WHERE c.companyName = ?1")
    User getUserByCompanyName(String companyName);
    @Query("SELECT n FROM User n WHERE n.registrationNumber = ?1")
    User getUserByRegistrationNumber(String registrationNumber);
}