package br.com.gilmarioarantes.jdbccrudv1.model;

public class Professor {

    private Long id;
    private String nome;
    private String email;
    private String titulacao;

    public Professor(){}

    public Professor(Long id, String nome, String email, String titulacao){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.titulacao = titulacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}
