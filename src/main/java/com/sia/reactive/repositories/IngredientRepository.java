package com.sia.reactive.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.sia.reactive.domain.Ingredient;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {
}

