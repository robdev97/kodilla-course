package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Maślana")
                .burgers(2)
                .sauce("mieszana mieszana")
                .ingredient("Onion")
                .ingredient("Potato")
                .ingredient("Hard-boiled egg")
                .ingredient("Tomato")
                .build();
        System.out.println(bigmac);


        //When
        int ingredientsCount = bigmac.getIngredients().size();
        int burgers = bigmac.getBurgers();
        String bun = bigmac.getBun();
        String sauce = bigmac.getSauce();

        //Then
        assertEquals(4, ingredientsCount);
        assertEquals(2, burgers);
        assertEquals("Maślana", bun);
        assertEquals("mieszana mieszana", sauce);
        assertTrue(bigmac.getIngredients().contains("Onion"));

    }
}
