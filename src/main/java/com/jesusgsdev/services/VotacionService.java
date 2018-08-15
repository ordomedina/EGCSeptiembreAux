
package com.jesusgsdev.services;

import com.jesusgsdev.entities.Votacion;
import com.jesusgsdev.repositories.VotacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VotacionService {

	private VotacionRepository votacionRepository;

	@Autowired
	public VotacionService(VotacionRepository votacionRepository) {
		this.votacionRepository = votacionRepository;
	}


	public List<Votacion> findAll() { return votacionRepository.findAll(); }

	public Optional<Votacion> findVotacionById(final Long id) {
		return this.votacionRepository.findVotacionById(id);
	}

	public Votacion save(final Votacion votacion) { return this.votacionRepository.save(votacion); }

	public void delete(final Votacion votacion) { this.votacionRepository.delete(votacion); }
}
