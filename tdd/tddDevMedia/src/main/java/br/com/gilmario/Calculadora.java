package br.com.gilmario;

/**
 * Created by gilmario on 21/02/17.
 */
public class Calculadora {
    public int soma(int valorA, int valorB){
        return valorA + valorB;
    }

    public int subtrai(int valorA, int valorB){
        return valorA - valorB;
    }

    public int divide(int valorA, int valorB) throws Exception{
        return valorA / valorB;
    }
}
