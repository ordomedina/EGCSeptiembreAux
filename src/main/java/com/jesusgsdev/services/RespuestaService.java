
package com.jesusgsdev.services;

import com.jesusgsdev.entities.Respuesta;
import com.jesusgsdev.repositories.RespuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service

public class RespuestaService {


	private RespuestaRepository respuestaRepository;

	@Autowired
	public RespuestaService(RespuestaRepository respuestaRepository) {
		this.respuestaRepository = respuestaRepository;
	}

	public Respuesta create() {
		final Respuesta res = new Respuesta();
		return res;
	}

	public Collection<Respuesta> findAll() {
		Collection<Respuesta> result;
		result = this.respuestaRepository.findAll();
		return result;
	}

	public Collection<Respuesta> listAll() {
		Collection<Respuesta> result;
		result = this.respuestaRepository.findAll();
		return result;
	}

	public Respuesta findOne(final int id) {
		Respuesta result;
		result = this.respuestaRepository.findOne(id);
		return result;
	}

	public Respuesta save(final Respuesta respuesta) {

		return this.respuestaRepository.save(respuesta);
	}

	public void delete(final Respuesta respuesta) {

		this.respuestaRepository.delete(respuesta);
	}

}
