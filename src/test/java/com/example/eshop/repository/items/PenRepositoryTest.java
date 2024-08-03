package com.example.eshop.repository.items;

import com.example.eshop.entity.items.Pen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


//@SpringBootTest
@DataJpaTest
class PenRepositoryTest {

    @Autowired
    private PenRepository penRepository;

    @AfterEach
    void tearDown(){
        penRepository.deleteAll();
    }

    @Test
    void findByName() {
        Pen pen1 = new Pen(null, "Pen1", 1.0, "description1", 100, "color1", 1);

        penRepository.saveAll(List.of(pen1));

        Optional<Pen> penOptional =  penRepository.findByName(pen1.getName());

        assertThat(penOptional).isPresent();

    }
}