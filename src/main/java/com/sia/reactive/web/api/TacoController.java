package com.sia.reactive.web.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

import lombok.extern.slf4j.Slf4j;

import com.sia.reactive.domain.Taco;
import com.sia.reactive.repositories.TacoRepository;

@Slf4j
@RestController
@RequestMapping(path = "/api/tacos", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class TacoController {
    
    private TacoRepository tacoRepo;

    public TacoController(TacoRepository tacoRepo){
     this.tacoRepo = tacoRepo;
    }

    @GetMapping(params = "recent")
    public Flux<Taco> recentTacos() {
        log.info("===recentTacos FLUX ===");
        return Flux.fromIterable(tacoRepo.findAll()).take(12);

    }
}
