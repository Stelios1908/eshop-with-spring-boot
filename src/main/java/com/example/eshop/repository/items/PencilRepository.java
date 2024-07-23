package com.example.eshop.repository.items;

import com.example.eshop.entity.items.Pencil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PencilRepository extends JpaRepository<Pencil,Long> {
}
