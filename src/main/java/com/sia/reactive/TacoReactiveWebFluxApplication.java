package com.sia.reactive;

import java.util.List;

import reactor.core.publisher.Flux;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

import com.sia.reactive.domain.Ingredient;
import com.sia.reactive.domain.Ingredient.Type;
import com.sia.reactive.domain.Taco;
import com.sia.reactive.repositories.IngredientRepository;
import com.sia.reactive.repositories.TacoRepository;
import java.util.Arrays;
import reactor.core.publisher.Mono;

@Slf4j
@SpringBootApplication
public class TacoReactiveWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoReactiveWebFluxApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(
            IngredientRepository repo, TacoRepository tacoRepo) {

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                log.info("[ >>>Saving ingredients...]");
                /* repo.save(saveAnIngredient("FLTO", "Flour Tortilla", Type.WRAP));
                repo.save(saveAnIngredient("COTO", "Corn Tortilla", Type.WRAP));
                repo.save(saveAnIngredient("GRBF", "Ground Beef", Type.PROTEIN));
                repo.save(saveAnIngredient("CARN", "Carnitas", Type.PROTEIN));
                repo.save(saveAnIngredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                repo.save(saveAnIngredient("LETC", "Lettuce", Type.VEGGIES));
                repo.save(saveAnIngredient("CHED", "Cheddar", Type.CHEESE));
                repo.save(saveAnIngredient("JACK", "Monterrey Jack", Type.CHEESE));
                repo.save(saveAnIngredient("SLSA", "Salsa", Type.SAUCE)); 
                repo.save(saveAnIngredient("SRCR", "Sour Cream", Type.SAUCE));*/

                Ingredient flourTortilla = saveAnIngredient("FLTO", "Flour Tortilla", Type.WRAP);
                /*Ingredient cornTortilla = saveAnIngredient("COTO", "Corn Tortilla", Type.WRAP);
                Ingredient groundBeef = saveAnIngredient("GRBF", "Ground Beef", Type.PROTEIN);
                Ingredient carnitas = saveAnIngredient("CARN", "Carnitas", Type.PROTEIN);
                Ingredient tomatoes = saveAnIngredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
                Ingredient lettuce = saveAnIngredient("LETC", "Lettuce", Type.VEGGIES);
                Ingredient cheddar = saveAnIngredient("CHED", "Cheddar", Type.CHEESE);
                Ingredient jack = saveAnIngredient("JACK", "Monterrey Jack", Type.CHEESE);
                Ingredient salsa = saveAnIngredient("SLSA", "Salsa", Type.SAUCE);
                Ingredient sourCream = saveAnIngredient("SRCR", "Sour Cream", Type.SAUCE);*/

                Taco taco1 = new Taco();
                taco1.setName("Carnivore");
                //long value = 10;
                //taco1.setId(value);

                // taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
                tacoRepo.save(taco1).subscribe();

                Taco taco2 = new Taco();
                taco2.setName("Veggie");
                //taco2.setIngredients(Arrays.asList(flourTortilla, cheddar));
                tacoRepo.save(taco2).subscribe();

                log.info("[ ...Saving tacos...]");
                Taco taco[] = new Taco[15];
                for (int i = 0; i < taco.length; i++) {
                    taco[i] = new Taco();
                    taco[i].setName("Id_" + i);
                    //taco[i].setIngredients(Arrays.asList(flourTortilla, cheddar));
                    tacoRepo.save(taco[i]).subscribe();
                }
                log.info("###GET TACOS DB ###");
                //List<Taco> lTacos = tacoRepo.findAll();
                Flux<Taco> lTacos = tacoRepo.findAll();

            }

            private Ingredient saveAnIngredient(String slug, String name, Type type) {
                log.info("[[[ saveAnIngredient ]]]");
                Ingredient ingredient = new Ingredient();
                ingredient.setSlug(slug);
                ingredient.setName(name);
                ingredient.setType(type);
                repo.save(ingredient).subscribe();
                return ingredient;
            }
        };

    }
}
