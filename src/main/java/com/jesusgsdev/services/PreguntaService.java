
package com.jesusgsdev.services;

import com.jesusgsdev.entities.Pregunta;
import com.jesusgsdev.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PreguntaService {


	private PreguntaRepository preguntaRepository;

	@Autowired
	public PreguntaService(PreguntaRepository preguntaRepository) {
		this.preguntaRepository = preguntaRepository;
	}

	public Pregunta create() {
		final Pregunta res = new Pregunta();
		return res;
	}

	public Collection<Pregunta> findAll() {
		Collection<Pregunta> result;
		result = this.preguntaRepository.findAll();
		return result;
	}

	public Collection<Pregunta> listAll() {
		Collection<Pregunta> result;
		result = this.preguntaRepository.findAll();
		return result;
	}

	public Pregunta findOne(final int id) {
		Pregunta result;
		result = this.preguntaRepository.findOne(id);
		return result;
	}

	public Pregunta save(final Pregunta pregunta) {

		return this.preguntaRepository.save(pregunta);
	}

	public void delete(final Pregunta pregunta) {

		this.preguntaRepository.delete(pregunta);
	}

}
