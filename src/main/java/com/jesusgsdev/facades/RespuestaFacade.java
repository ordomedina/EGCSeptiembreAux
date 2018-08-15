package com.jesusgsdev.facades;

import com.jesusgsdev.dtos.RespuestaDTO;
import com.jesusgsdev.entities.Respuesta;
import com.jesusgsdev.services.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jesusgsdev.constants.ErrorCode.RESPUESTA_NO_ENCONTRADA;

@Service
public class RespuestaFacade {

    @Autowired
    private RespuestaService respuestaService;

    public RespuestaDTO addRespuesta(RespuestaDTO respuestaDTO) {
        Respuesta respuesta = new Respuesta(respuestaDTO.getTextoRespuesta(), respuestaDTO.getSeleccionada());
        respuesta = respuestaService.save(respuesta);
        respuestaDTO.setId(respuesta.getId());
        return respuestaDTO;
    }

    public RespuestaDTO findRespuestaById(Long id){
        Optional<Respuesta> respuestaOptional = respuestaService.findRespuestaById(id);
        if(respuestaOptional.isPresent()) {
            return RespuestaDTO.fromRespuesta(respuestaOptional.get());
        }

        return respuestaCuandoRespuestaNoEncontrada();
    }

    public List<RespuestaDTO> findAll(){
        return respuestaService.findAll().stream().map(RespuestaDTO::fromRespuesta).collect(Collectors.toList());
    }

    public RespuestaDTO eliminarRespuesta(Long id) {
        Optional<Respuesta> respuestaOptional = respuestaService.findRespuestaById(id);
        if(!respuestaOptional.isPresent()) {
            return respuestaCuandoRespuestaNoEncontrada();
        }

        respuestaService.delete(respuestaOptional.get());

        return new RespuestaDTO();
    }

    public RespuestaDTO actualizarRespuesta(Long id, RespuestaDTO respuestaDTO) {
        Optional<Respuesta> respuestaOptional = respuestaService.findRespuestaById(id);
        if(!respuestaOptional.isPresent()) {
            return respuestaCuandoRespuestaNoEncontrada();
        }

        Respuesta respuesta = respuestaOptional.get();
        respuesta.setTextoRespuesta(respuestaDTO.getTextoRespuesta());
        respuesta.setSeleccionada(respuestaDTO.getSeleccionada());

        respuestaService.save(respuesta);

        return RespuestaDTO.fromRespuesta(respuesta);
    }

    private RespuestaDTO respuestaCuandoRespuestaNoEncontrada() {
        RespuestaDTO RespuestaDTO = new RespuestaDTO();
        RespuestaDTO.setErrorMessage(RESPUESTA_NO_ENCONTRADA.getMessage());
        RespuestaDTO.setError(RESPUESTA_NO_ENCONTRADA.getCode());
        return RespuestaDTO;
    }



}
