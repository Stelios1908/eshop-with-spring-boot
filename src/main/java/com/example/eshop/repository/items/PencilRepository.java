package com.example.eshop.repository.items;

import com.example.eshop.entity.items.Pen;
import com.example.eshop.entity.items.Pencil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PencilRepository extends JpaRepository<Pencil,Long> {
    @Query("SELECT s FROM Pencil s WHERE s.name = ?1")
    Optional<Pencil> findByName(String name);
}
