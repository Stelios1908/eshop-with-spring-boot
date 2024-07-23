package com.example.eshop.repository.items;

import com.example.eshop.entity.items.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository  extends JpaRepository<Paper,Long> {

}
