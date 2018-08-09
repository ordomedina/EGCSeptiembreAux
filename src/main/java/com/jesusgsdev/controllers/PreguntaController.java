package com.jesusgsdev.controllers;

import com.jesusgsdev.dtos.PreguntaDTO;
import com.jesusgsdev.facades.PreguntaFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    private PreguntaFacade PreguntaFacade;

    @PostMapping
    public PreguntaDTO addPregunta(@RequestBody @Valid PreguntaDTO PreguntaDTO) {
        return PreguntaFacade.addPregunta(PreguntaDTO);
    }

    @GetMapping
    public List<PreguntaDTO> getAll(){
        return PreguntaFacade.findAll();
    }

    @GetMapping(params = "id")
    public PreguntaDTO getPreguntaByISBN(@RequestParam("id") Long id) {
        return PreguntaFacade.findPreguntaById(id);
    }

}
