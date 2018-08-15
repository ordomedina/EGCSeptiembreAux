package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Respuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

    List<Respuesta> findAll();

    Optional<Respuesta> findRespuestaById(Long id);

}
