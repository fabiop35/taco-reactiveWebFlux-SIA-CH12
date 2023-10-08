package com.sia.reactive.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.FetchType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.NonNull;

@Data
//@Entity
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
public class Taco {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //@Size(min=5, message="Name must be at least 5 characters long")
    private @NonNull
    String name;

    private Date createdAt = new Date();
    //@Size(min=1, message="You must choose at least 1 ingredient")
    //@ManyToMany(fetch = FetchType.EAGER)
    private List<Ingredient> ingredients = new ArrayList<>();

    /*public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    } */
    private Set<Long> ingredientIds = new HashSet<>();

    public void addIngredient(Ingredient ingredient) {
        ingredientIds.add(ingredient.getId());
    }

}
