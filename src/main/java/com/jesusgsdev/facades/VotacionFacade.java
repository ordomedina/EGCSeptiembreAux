package com.jesusgsdev.facades;

import com.jesusgsdev.dtos.VotacionDTO;
import com.jesusgsdev.entities.Votacion;
import com.jesusgsdev.services.VotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jesusgsdev.constants.ErrorCode.VOTACION_NO_ENCONTRADA;

@Service
public class VotacionFacade {

    @Autowired
    private VotacionService votacionService;

    public VotacionDTO addVotacion(VotacionDTO votacionDTO) {
        Votacion votacion = new Votacion(votacionDTO.getIdCenso(), votacionDTO.getIdGrupo(), votacionDTO.getTitulo()
                , votacionDTO.getDescripcion(), votacionDTO.getFechaIni(), votacionDTO.getFechaFin(), votacionDTO.getClave());
        votacion = votacionService.save(votacion);
        votacionDTO.setId(votacion.getId());
        return votacionDTO;
    }

    public VotacionDTO findVotacionById(Long id){
        Optional<Votacion> votacionOptional = votacionService.findVotacionById(id);
        if(votacionOptional.isPresent()) {
            return VotacionDTO.fromVotacion(votacionOptional.get());
        }

        return respuestaCuandoVotacionNoEncontrada();
    }

    public List<VotacionDTO> findAll(){
        return votacionService.findAll().stream().map(VotacionDTO::fromVotacion).collect(Collectors.toList());
    }

    public VotacionDTO eliminarVotacion(Long id) {
        Optional<Votacion> votacionOptional = votacionService.findVotacionById(id);
        if(!votacionOptional.isPresent()) {
            return respuestaCuandoVotacionNoEncontrada();
        }

        votacionService.delete(votacionOptional.get());

        return new VotacionDTO();
    }

    public VotacionDTO actualizarVotacion(Long id, VotacionDTO votacionDTO) {
        Optional<Votacion> votacionOptional = votacionService.findVotacionById(id);
        if(!votacionOptional.isPresent()) {
            return respuestaCuandoVotacionNoEncontrada();
        }

        Votacion votacion = votacionOptional.get();
        votacion.setIdCenso(votacionDTO.getIdCenso());
        votacion.setIdGrupo(votacionDTO.getIdGrupo());
        votacion.setTitulo(votacionDTO.getTitulo());
        votacion.setDescripcion(votacionDTO.getDescripcion());
        votacion.setFechaIni(votacionDTO.getFechaIni());
        votacion.setFechaIni(votacionDTO.getFechaIni());
        votacion.setClave(votacionDTO.getClave());

        votacionService.save(votacion);

        return VotacionDTO.fromVotacion(votacion);
    }

    private VotacionDTO respuestaCuandoVotacionNoEncontrada() {
        VotacionDTO VotacionDTO = new VotacionDTO();
        VotacionDTO.setErrorMessage(VOTACION_NO_ENCONTRADA.getMessage());
        VotacionDTO.setError(VOTACION_NO_ENCONTRADA.getCode());
        return VotacionDTO;
    }
    
}
