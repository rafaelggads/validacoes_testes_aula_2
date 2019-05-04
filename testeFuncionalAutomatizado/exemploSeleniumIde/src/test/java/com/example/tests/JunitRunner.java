package com.example.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by gilmario on 20/03/17.
 */
public class JunitRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(GeraSenha.class, ValidaCPFInvalido.class, ValidaCPFValido.class);

        for(Failure failure : result.getFailures()){
            System.out.println(result.toString());
        }

        if(result.wasSuccessful()){
            System.out.println("All test finished successfully...");
        }
    }
}
