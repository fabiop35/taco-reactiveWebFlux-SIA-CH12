package com.sia.reactive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sia.reactive.domain.Ingredient;
import com.sia.reactive.domain.Ingredient.Type;
import com.sia.reactive.domain.Taco;
import com.sia.reactive.repositories.IngredientRepository;
import com.sia.reactive.repositories.TacoRepository;
import java.util.Arrays;

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
                repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));

                Ingredient flourTortilla = new Ingredient("FLTO", "Flour Tortilla", Type.WRAP);
                Ingredient cornTortilla = new Ingredient("COTO", "Corn Tortilla", Type.WRAP);
                Ingredient groundBeef = new Ingredient("GRBF", "Ground Beef", Type.PROTEIN);
                Ingredient carnitas = new Ingredient("CARN", "Carnitas", Type.PROTEIN);
                Ingredient tomatoes = new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES);
                Ingredient lettuce = new Ingredient("LETC", "Lettuce", Type.VEGGIES);
                Ingredient cheddar = new Ingredient("CHED", "Cheddar", Type.CHEESE);
                Ingredient jack = new Ingredient("JACK", "Monterrey Jack", Type.CHEESE);
                Ingredient salsa = new Ingredient("SLSA", "Salsa", Type.SAUCE);
                Ingredient sourCream = new Ingredient("SRCR", "Sour Cream", Type.SAUCE);

                Taco taco1 = new Taco();
                taco1.setName("Carnivore");
                taco1.setIngredients(Arrays.asList(flourTortilla, groundBeef, carnitas, sourCream, salsa, cheddar));
                tacoRepo.save(taco1);

                Taco taco2 = new Taco();
                taco2.setName("Veggie");
                taco2.setIngredients(Arrays.asList(flourTortilla, cheddar));
                tacoRepo.save(taco2);
            }
        };

    }
}
