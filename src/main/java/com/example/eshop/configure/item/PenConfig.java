package com.example.eshop.configure.item;

import com.example.eshop.entity.items.Pen;
import com.example.eshop.repository.items.PenRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PenConfig {
/*
    @Bean
    CommandLineRunner commandLineRunnerPen(PenRepository penRepository){
        return args -> {
            Pen pen1 = new Pen(
                    null,
                    "Pik",
                    3.0,
                    "perfect write",
                    150,
                    "black",
                    3
            );

            Pen pen2 = new Pen(
                    null,
                    "Tik",
                    3.0,
                    "good write",
                    150,
                    "grew",
                    3
            );
            Pen pen3= new Pen(
                    null,
                    "Pol",
                    3.0,
                    "bad write",
                    150,
                    "grew",
                    3
            );

            penRepository.saveAll(
                    List.of(pen1,pen2,pen3)
            );
        };
    }*/
}
