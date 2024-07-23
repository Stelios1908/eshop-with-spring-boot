package com.example.eshop.entity.items;

import com.example.eshop.enums.ItemTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


    @Entity
    @Table(name = "paper")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class Paper extends Item{

        @NotNull
        @Column(name ="weigth")
        private int weigth;

        @NotNull
        @Column(name ="page")
        private int pages;

        public Paper(Long id, String name, Double price, String description, int stock, int weight, int pages) {
            super(id, name, ItemTypeEnum.Paper,price, description, stock); // Κλήση του κατασκευαστή της γονικής κλάσης
            this.weigth= weight;
            this.pages = pages;
        }

    }
