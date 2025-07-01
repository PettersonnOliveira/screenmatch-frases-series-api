package com.example.Screenmatch_frases_series.Controller;

import com.example.Screenmatch_frases_series.dto.FrasesDTO;
import com.example.Screenmatch_frases_series.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    public class FrasesController {
        @Autowired
        private FraseService servico;

         // Endpoint para obter uma frase aleatória
        @GetMapping("series/frases")
        public FrasesDTO obterFrasesAleatorias() {
             return servico.obterFrasesAleatorias().get(0);
         }

    }


