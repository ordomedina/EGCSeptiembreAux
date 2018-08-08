
package com.jesusgsdev.repositories;

import com.jesusgsdev.entities.Votacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotacionRepository extends CrudRepository<Votacion, Long> {

}
