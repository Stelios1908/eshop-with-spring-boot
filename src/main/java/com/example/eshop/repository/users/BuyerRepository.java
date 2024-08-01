package com.example.eshop.repository.users;

import com.example.eshop.entity.users.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer,Long> {


    //@Query("SELECT s FROM Buyer s WHERE s.email = ?1")
    Optional<Buyer> findByEmail(String email);

    Optional<Buyer> findByName(String name);
}
