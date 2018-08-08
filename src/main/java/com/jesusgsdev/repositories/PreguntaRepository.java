
package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Pregunta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreguntaRepository extends CrudRepository<Pregunta, Long> {

}
