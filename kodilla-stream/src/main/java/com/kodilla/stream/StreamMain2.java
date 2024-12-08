package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain2 {

    public static void main(String[] args) {


        //Task 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        System.out.println("Example lamba expression for beautification.");
        poemBeautifier.beautify("Dress to impress", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("It's raining cats and dogs!", text -> text.toUpperCase());

        System.out.println("My 2 additional beautification's");
        poemBeautifier.beautify("Lamba expression training ", text -> text + "(;>");
        poemBeautifier.beautify("Lamba expression written backwards", text -> new StringBuilder(text).reverse().toString());

        System.out.println("The End :)");


    }
}
