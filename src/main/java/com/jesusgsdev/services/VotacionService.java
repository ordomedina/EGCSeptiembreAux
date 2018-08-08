
package com.jesusgsdev.services;

import com.jesusgsdev.entities.Votacion;
import com.jesusgsdev.repositories.VotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VotacionService {


	private VotacionRepository votacionRepository;

	@Autowired
	public VotacionService(VotacionRepository votacionRepository) {
		this.votacionRepository = votacionRepository;
	}

	public Votacion create() {
		final Votacion res = new Votacion();
		return res;
	}

	public Collection<Votacion> findAll() {
		Collection<Votacion> result;
		result = this.votacionRepository.findAll();
		return result;
	}

	public Collection<Votacion> listAll() {
		Collection<Votacion> result;
		result = this.votacionRepository.findAll();
		return result;
	}

	public Votacion findOne(final int id) {
		Votacion result;
		result = this.votacionRepository.findOne(id);
		return result;
	}

	public Votacion save(final Votacion votacion) {

		return this.votacionRepository.save(votacion);
	}

	public void delete(final Votacion votacion) {

		this.votacionRepository.delete(votacion);
	}
}
