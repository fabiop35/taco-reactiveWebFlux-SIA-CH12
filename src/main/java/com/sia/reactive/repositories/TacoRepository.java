package com.sia.reactive.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sia.reactive.domain.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
