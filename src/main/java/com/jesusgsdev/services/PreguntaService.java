
package com.jesusgsdev.services;

import com.jesusgsdev.entities.Pregunta;
import com.jesusgsdev.repositories.PreguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PreguntaService {

	private PreguntaRepository preguntaRepository;

	@Autowired
	public PreguntaService(PreguntaRepository preguntaRepository) {
		this.preguntaRepository = preguntaRepository;
	}

	public List<Pregunta> findAll() {
		return preguntaRepository.findAll();
	}

	public Optional<Pregunta> findPreguntaById(final Long id) {
		return this.preguntaRepository.findPreguntaById(id);
	}

	public Pregunta save(final Pregunta pregunta) {
		return this.preguntaRepository.save(pregunta);
	}

	public void delete(final Pregunta pregunta) {
		this.preguntaRepository.delete(pregunta);
	}

}
