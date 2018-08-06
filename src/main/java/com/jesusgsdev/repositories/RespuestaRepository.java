package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Respuesta;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}
