
package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Long> {

    List<Pregunta> findAll();

    Optional<Pregunta> findPreguntaById(Long id);

}
