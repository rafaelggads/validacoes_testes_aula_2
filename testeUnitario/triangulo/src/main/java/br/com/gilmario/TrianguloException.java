package br.com.gilmario;

/**
 * Created by gilmario on 03/03/17.
 */
public class TrianguloException extends Exception{
    public TrianguloException(){
        super("Os valores informados não formam um triangulo!");
    }
}
