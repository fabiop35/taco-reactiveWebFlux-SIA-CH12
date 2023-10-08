package com.sia.reactive.domain;

//import javax.persistence.Entity;
//import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.data.annotation.Id;

@Data
//@Entity
@AllArgsConstructor
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor //(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
    private  long id;
    private @NonNull String slug;
    private @NonNull String name;
    private @NonNull Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}
