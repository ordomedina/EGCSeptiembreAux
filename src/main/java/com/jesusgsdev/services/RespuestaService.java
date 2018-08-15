
package com.jesusgsdev.services;

import com.jesusgsdev.entities.Respuesta;
import com.jesusgsdev.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {

	private RespuestaRepository respuestaRepository;

	@Autowired
	public RespuestaService(RespuestaRepository respuestaRepository) {
		this.respuestaRepository = respuestaRepository;
	}

	public List<Respuesta> findAll() { return  respuestaRepository.findAll(); }

	public Optional<Respuesta> findRespuestaById(final Long id) {
		return this.respuestaRepository.findRespuestaById(id);
	}

	public Respuesta save(final Respuesta respuesta) { return this.respuestaRepository.save(respuesta); }

	public void delete(final Respuesta respuesta) { this.respuestaRepository.delete(respuesta); }

}
