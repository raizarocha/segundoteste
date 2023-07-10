package com.example.segundoteste;

public class Candidato {
    private Integer id;

    private String nome;

    private String status;


    public Candidato(Integer id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
