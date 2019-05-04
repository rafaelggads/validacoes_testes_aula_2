package br.com.gilmario.model;

import java.util.Arrays;

/**
 * Created by gilmario on 16/02/17.
 * Página 17 do JUnit-Tutorial.pdf
 */
public class FirstDayAtSchool {

    public String[] prepareMyBag(){
        String[] schoolBag = {"Books", "Notebooks", "Pens"};
        System.out.println("My School bag contains: " + Arrays.toString(schoolBag));
        return schoolBag;
    }

    public String[] addPencils(){
        String[] schoolBag = {"Books", "Notebooks", "Pens", "Pencils"};
        System.out.println("My School bag contains: " + Arrays.toString(schoolBag));
        return schoolBag;
    }
}
