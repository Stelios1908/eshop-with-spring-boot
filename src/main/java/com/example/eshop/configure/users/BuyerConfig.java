package com.example.eshop.configure.users;


import com.example.eshop.entity.users.Buyer;
import com.example.eshop.enums.BuyerCategoryEnum;
import com.example.eshop.repository.users.BuyerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BuyerConfig  {

    @Bean
    CommandLineRunner commandLineRunnerBuyer(BuyerRepository buyerRepositiry) {
            return args -> {

                Buyer buyer1 = new Buyer(
                        null,
                        "stelios",
                        "stelios@gmail.com",
                        10,
                        BuyerCategoryEnum.CAT_A
                );

                Buyer buyer2 = new Buyer(
                        null,
                        "sakis",
                        "sakis@gmail.com",
                        150,
                        BuyerCategoryEnum.CAT_B
                );

                Buyer buyer3 = new Buyer(
                        null,
                        "panagiotis",
                        "panagiotis@gmail.com",
                        150,
                        BuyerCategoryEnum.CAT_C
                );


                buyerRepositiry.saveAll(
                        List.of(buyer1,buyer2,buyer3)
                );

            };
        }}

