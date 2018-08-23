package com.jesusgsdev.dtos;

import com.jesusgsdev.entities.Respuesta;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class RespuestaDTO extends BaseDTO {

    private Long id;

    @NotEmpty
    @Length(max = 140)
    @Column(length = 140)
    private String textoRespuesta;


    private Boolean seleccionada = false;


    public RespuestaDTO() { }

    public RespuestaDTO(Long id, @NotEmpty @Length(max = 255) String textoRespuesta, Boolean seleccionada) {
        this.id = id;
        this.textoRespuesta = textoRespuesta;
        this.seleccionada = seleccionada;
    }

    public RespuestaDTO(String error, String errorMessage, Long id, @NotEmpty @Length(max = 255) String textoRespuesta, Boolean seleccionada) {
        super(error, errorMessage);
        this.id = id;
        this.textoRespuesta = textoRespuesta;
        this.seleccionada = seleccionada;
    }

    public static RespuestaDTO fromRespuesta(Respuesta respuesta){
        return new RespuestaDTO(respuesta.getId(), respuesta.getTextoRespuesta(), respuesta.getSeleccionada());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public Boolean getSeleccionada() {
        return seleccionada;
    }

    public void setSeleccionada(Boolean seleccionada) {
        this.seleccionada = seleccionada;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("textoRespuesta", textoRespuesta)
                .append("seleccionada", seleccionada)
                .toString();
    }
}
