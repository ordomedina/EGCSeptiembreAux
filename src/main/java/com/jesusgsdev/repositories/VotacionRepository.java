
package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Votacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VotacionRepository extends CrudRepository<Votacion, Long> {

    List<Votacion> findAll();

    Optional<Votacion> findVotacionById(Long id);

}
