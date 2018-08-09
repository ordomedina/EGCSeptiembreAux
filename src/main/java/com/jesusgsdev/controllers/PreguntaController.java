package com.jesusgsdev.controllers;

import com.jesusgsdev.dtos.PreguntaDTO;
import com.jesusgsdev.facades.PreguntaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaFacade preguntaFacade;

    @PostMapping
    public PreguntaDTO addPregunta(@RequestBody @Valid PreguntaDTO preguntaDTO) {
        return preguntaFacade.addPregunta(preguntaDTO);
    }

    @PutMapping(params = "id")
    public PreguntaDTO actualizarPregunta(@RequestBody @Valid PreguntaDTO preguntaDTO, @RequestParam("id") Long id) {
        return preguntaFacade.actualizarPregunta(id, preguntaDTO);
    }

    @DeleteMapping(params = "id")
    public PreguntaDTO eliminarPregunta(@RequestParam("id") Long id) {
        return preguntaFacade.eliminarPregunta(id);
    }

    @GetMapping
    public List<PreguntaDTO> getAll(){
        return preguntaFacade.findAll();
    }

    @GetMapping(params = "id")
    public PreguntaDTO getPreguntaByISBN(@RequestParam("id") Long id) {
        return preguntaFacade.findPreguntaById(id);
    }

}
