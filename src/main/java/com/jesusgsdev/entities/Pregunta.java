
package com.jesusgsdev.entities;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "pregunta")
public class Pregunta extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String	texto_pregunta;
	private String	tipo_pregunta;

	public Pregunta() { }

	public Pregunta(String	texto_pregunta, String	tipo_pregunta) {
		this.texto_pregunta = texto_pregunta;
		this.tipo_pregunta = tipo_pregunta;
	}


	public String getTexto_pregunta() {
		return this.texto_pregunta;
	}

	public void setTexto_pregunta(final String texto_pregunta) {
		this.texto_pregunta = texto_pregunta;
	}

	public String getTipo_pregunta() {
		return this.tipo_pregunta;
	}

	public void setTipo_pregunta(final String tipo_pregunta) {
		this.tipo_pregunta = tipo_pregunta;
	}


	// Relationships
	private Collection<Respuesta>	respuestas;
	private Votacion				votacion;
	private Pregunta				dependencia;


	@Valid
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	public Pregunta getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(final Pregunta dependencia) {
		this.dependencia = dependencia;
	}

	@Valid
	@OneToMany(mappedBy = "pregunta")
	public Collection<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(final Collection<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Valid
	@ManyToOne
	public Votacion getVotacion() {
		return this.votacion;
	}

	public void setVotacion(final Votacion votacion) {
		this.votacion = votacion;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pregunta pregunta = (Pregunta) o;
		return Objects.equals(texto_pregunta, pregunta.texto_pregunta) &&
				Objects.equals(tipo_pregunta, pregunta.tipo_pregunta);
	}

	@Override
	public int hashCode() {

		return Objects.hash(texto_pregunta, tipo_pregunta);
	}


}