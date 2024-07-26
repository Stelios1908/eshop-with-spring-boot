package com.example.eshop.configure.item;

import com.example.eshop.entity.items.Item;
import com.example.eshop.entity.items.Notebook;
import com.example.eshop.entity.users.Buyer;
import com.example.eshop.repository.items.NotebookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class NoteBoolConfig {

    /*
    @Bean
    CommandLineRunner commandLineRunnerNotebook(NotebookRepository notebookRepository){
        return args -> {
            Notebook notebook1 = new Notebook(
                    null,
                    "PIicup",
                    10.0,
                    "it amazing",
                    100,
                    2
            );
            Notebook notebook2 = new Notebook(
                    null,
                    "Picolo",
                    10.0,
                    "strong",
                    100,
                    2
            );

            notebookRepository.saveAll(
                    List.of(notebook1,notebook2)
            );
;
        };
    }*/
}
