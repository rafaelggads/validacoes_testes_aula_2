package br.com.gilmario;

/**
 * Created by gilmario on 21/02/17.
 */
public class LogMock implements GeradorDeLog{

    private String nome;

    @Override
    public void criaLog(String nomePessoa) {
        this.nome = nomePessoa;
    }

    public String getNome(){
        return nome;
    }
}
