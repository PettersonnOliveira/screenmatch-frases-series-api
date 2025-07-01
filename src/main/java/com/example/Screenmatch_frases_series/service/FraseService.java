package com.example.Screenmatch_frases_series.service;

import com.example.Screenmatch_frases_series.dto.FrasesDTO;
import com.example.Screenmatch_frases_series.model.Frase;
import com.example.Screenmatch_frases_series.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FraseService {
    @Autowired
    private FraseRepository repositorio;

    public List<FrasesDTO> obterFrasesAleatorias() {
        Frase frase = repositorio.buscarFraseAleatoria();
        FrasesDTO dto = new FrasesDTO(frase.getTitulo(), frase.getFrase(), frase.getPoster(), frase.getPersonagem());

    return List.of(dto);}
}
