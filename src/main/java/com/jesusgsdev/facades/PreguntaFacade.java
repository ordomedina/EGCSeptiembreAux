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

    public PreguntaDTO addPregunta(PreguntaDTO preguntaDTO) {
        Pregunta pregunta = new Pregunta(preguntaDTO.getTextoPregunta(), preguntaDTO.getTipoPregunta());
        pregunta = preguntaService.save(pregunta);
        preguntaDTO.setId(pregunta.getId());
        return preguntaDTO;
    }

    public PreguntaDTO findPreguntaById(Long id){
        Optional<Pregunta> preguntaOptional = preguntaService.findPreguntaById(id);
        if(preguntaOptional.isPresent()) {
            return PreguntaDTO.fromPregunta(preguntaOptional.get());
        }

        return respuestaCuandoPreguntaNoEncontrada();
    }

    public List<PreguntaDTO> findAll(){
        return preguntaService.findAll().stream().map(PreguntaDTO::fromPregunta).collect(Collectors.toList());
    }

    public PreguntaDTO eliminarPregunta(Long id) {
        Optional<Pregunta> preguntaOptional = preguntaService.findPreguntaById(id);
        if(!preguntaOptional.isPresent()) {
            return respuestaCuandoPreguntaNoEncontrada();
        }

        preguntaService.delete(preguntaOptional.get());

        return new PreguntaDTO();
    }

    public PreguntaDTO actualizarPregunta(Long id, PreguntaDTO preguntaDTO) {
        Optional<Pregunta> preguntaOptional = preguntaService.findPreguntaById(id);
        if(!preguntaOptional.isPresent()) {
            return respuestaCuandoPreguntaNoEncontrada();
        }

        Pregunta pregunta = preguntaOptional.get();
        pregunta.setTexto_pregunta(preguntaDTO.getTextoPregunta());
        pregunta.setTipo_pregunta(preguntaDTO.getTipoPregunta());

        preguntaService.save(pregunta);

        return PreguntaDTO.fromPregunta(pregunta);
    }

    private PreguntaDTO respuestaCuandoPreguntaNoEncontrada() {
        PreguntaDTO PreguntaDTO = new PreguntaDTO();
        PreguntaDTO.setErrorMessage(PREGUNTA_NO_ENCONTRADA.getMessage());
        PreguntaDTO.setError(PREGUNTA_NO_ENCONTRADA.getCode());
        return PreguntaDTO;
    }
}
