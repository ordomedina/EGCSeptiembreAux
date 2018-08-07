
package com.jesusgsdev.entities;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "respuesta")
public class Respuesta extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String	texto_respuesta;
	private Boolean	seleccionada;

	public Respuesta() { }

	public Respuesta(String	texto_respuesta, Boolean	seleccionada) {
		this.texto_respuesta = texto_respuesta;
		this.seleccionada = seleccionada;
	}


	@NotBlank
	public String getTexto_respuesta() {
		return this.texto_respuesta;
	}

	public void setTexto_respuesta(final String texto_respuesta) {
		this.texto_respuesta = texto_respuesta;
	}

	public Boolean getSeleccionada() {
		return this.seleccionada;
	}

	public void setSeleccionada(final Boolean seleccionada) {
		this.seleccionada = seleccionada;
	}


	// Relationships
	private Pregunta pregunta;


	@ManyToOne
	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(final Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Respuesta respuesta = (Respuesta) o;
		return Objects.equals(texto_respuesta, respuesta.texto_respuesta) &&
				Objects.equals(seleccionada, respuesta.seleccionada);
	}

	@Override
	public int hashCode() {

		return Objects.hash(texto_respuesta, seleccionada);
	}
}

