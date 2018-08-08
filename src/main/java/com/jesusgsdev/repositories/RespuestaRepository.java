package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Respuesta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespuestaRepository extends CrudRepository<Respuesta, Long> {

}
