package com.example.Screenmatch_frases_series.dto;

public class FrasesDTO {
    private Long id;
    private String titulo;
    private String frase;
    private String poster;
    private String personagem;

    public FrasesDTO() {
    }

    public FrasesDTO(String titulo, String frase, String poster, String personagem) {
        this.titulo = titulo;
        this.frase = frase;
        this.poster = poster;
        this.personagem = personagem;
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
