package com.jesusgsdev.facades;

import com.jesusgsdev.dtos.PreguntaDTO;
import com.jesusgsdev.entities.Pregunta;
import com.jesusgsdev.services.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.jesusgsdev.constants.ErrorCode.PREGUNTA_NO_ENCONTRADA;

@Service
public class PreguntaFacade {

    @Autowired
    private PreguntaService preguntaService;

    public PreguntaDTO addPregunta(PreguntaDTO PreguntaDTO) {
        Pregunta pregunta = new Pregunta(PreguntaDTO.getTextoPregunta(), PreguntaDTO.getTipoPregunta());
        pregunta = preguntaService.save(pregunta);
        PreguntaDTO.setId(pregunta.getId());
        return PreguntaDTO;
    }

    public PreguntaDTO findPreguntaById(Long id){
        Optional<Pregunta> preguntaOptional = preguntaService.findPreguntaById(id);
        if(preguntaOptional.isPresent()) {
            return PreguntaDTO.fromPregunta(preguntaOptional.get());
        }

        PreguntaDTO PreguntaDTO = new PreguntaDTO();
        PreguntaDTO.setErrorMessage(PREGUNTA_NO_ENCONTRADA.getMessage());
        PreguntaDTO.setError(PREGUNTA_NO_ENCONTRADA.getCode());
        return PreguntaDTO;
    }

    public List<PreguntaDTO> findAll(){
        return preguntaService.findAll().stream().map(PreguntaDTO::fromPregunta).collect(Collectors.toList());
    }
}
