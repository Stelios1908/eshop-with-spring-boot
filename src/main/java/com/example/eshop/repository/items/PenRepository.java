package com.example.eshop.repository.items;

import com.example.eshop.entity.items.Pen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PenRepository extends JpaRepository<Pen,Long> {

    @Query ("SELECT s FROM Pen s WHERE s.name = ?1")
    Optional<Pen> findByName(String name);
}
