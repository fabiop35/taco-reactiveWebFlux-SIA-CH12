package com.sia.reactive.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sia.reactive.domain.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}

