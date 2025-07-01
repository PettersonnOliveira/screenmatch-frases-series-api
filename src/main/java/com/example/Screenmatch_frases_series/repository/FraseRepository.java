package com.example.Screenmatch_frases_series.repository;

import com.example.Screenmatch_frases_series.model.Frase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FraseRepository extends JpaRepository<Frase, Long> {

@Query("SELECT f FROM Frase f order by function('RANDOM') LIMIT 1")
    Frase buscarFraseAleatoria();
}
