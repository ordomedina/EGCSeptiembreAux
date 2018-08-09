package com.jesusgsdev.dtos;

import com.jesusgsdev.entities.Pregunta;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class PreguntaDTO extends BaseDTO {

    private Long id;

    @NotEmpty
    @Length(max = 255)
    private String textoPregunta;

    @NotEmpty
    @Length(max = 255)
    private String tipoPregunta;

    public PreguntaDTO() { }

    public PreguntaDTO(Long id, @NotEmpty @Length(max = 255) String textoPregunta, @NotEmpty @Length(max = 255) String tipoPregunta) {
        this.id = id;
        this.textoPregunta = textoPregunta;
        this.tipoPregunta = tipoPregunta;
    }

    public PreguntaDTO(String error, String errorMessage, Long id, @NotEmpty @Length(max = 255) String textoPregunta, @NotEmpty @Length(max = 255) String tipoPregunta) {
        super(error, errorMessage);
        this.id = id;
        this.textoPregunta = textoPregunta;
        this.tipoPregunta = tipoPregunta;
    }

    public static PreguntaDTO fromPregunta(Pregunta pregunta) {
        return new PreguntaDTO(pregunta.getId(), pregunta.getTexto_pregunta(), pregunta.getTipo_pregunta());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("textoPregunta", textoPregunta)
                .append("tipoPregunta", tipoPregunta)
                .toString();
    }
}
