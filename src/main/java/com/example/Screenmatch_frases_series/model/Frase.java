package com.example.Screenmatch_frases_series.model;

import jakarta.persistence.*;

@Entity
@Table(name = "frases")
public class Frase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String frase;
    private String poster;
    private String personagem;

    public Frase() {
    }
    public Frase(Long id, String titulo, String frase, String poster, String personagem) {
        this.id = id;
        this.titulo = titulo;
        this.frase = frase;
        this.poster = poster;
        this.personagem = personagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPersonagem() {
        return personagem;
    }

    public void setPersonagem(String personagem) {
        this.personagem = personagem;
    }
}
