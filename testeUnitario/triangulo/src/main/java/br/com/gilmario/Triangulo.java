package br.com.gilmario;

/**
 * Created by gilmario on 03/03/17.
 */
public class Triangulo {

    public boolean validaTriangulo(int a, int b, int c) throws TrianguloException{
        if ((c < a+b) && (b < c+a) && (a < c+b)){
            return true;
        }else{
            throw new TrianguloException();
        }
    }

    public String obtemTipoTriangulo(int a, int b, int c){
        String tipo = null;
        {if ((a==b) && (b==c))
            tipo = " O triangulo é equilatero ";
        else if ((a==b)||(b==c)||(a==c))
            tipo = " O triangulo é isoceles ";
        else if ((a!=b)||(b!=c)||(a!=c))
            tipo = " O triangulo é escaleno ";
        }
        return tipo;
    }
}
