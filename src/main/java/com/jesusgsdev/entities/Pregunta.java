
package com.jesusgsdev.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pregunta")
public class Pregunta extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String	textoPregunta;

	private String	tipoPregunta;

	@OneToMany(mappedBy = "pregunta")
	private List<Respuesta> respuestas;

	@ManyToOne
	@JoinColumn(name = "votacion_id")
	private Votacion votacion;

	@OneToOne
	@JoinColumn(name = "pregunta_id")
	private Pregunta dependencia;

	public Pregunta() { }

	public Pregunta(String	textoPregunta, String	tipoPregunta) {
		this.textoPregunta = textoPregunta;
		this.tipoPregunta = tipoPregunta;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoPregunta() {
		return this.textoPregunta;
	}

	public void setTextoPregunta(final String textoPregunta) {
		this.textoPregunta = textoPregunta;
	}

	public String getTipoPregunta() {
		return this.tipoPregunta;
	}

	public void setTipoPregunta(final String tipoPregunta) {
		this.tipoPregunta = tipoPregunta;
	}

	//@Valid
	//@OneToOne(optional = true, cascade = CascadeType.ALL)
	public Pregunta getDependencia() {
		return this.dependencia;
	}

	public void setDependencia(final Pregunta dependencia) {
		this.dependencia = dependencia;
	}

//	@Valid
	//@OneToMany(mappedBy = "pregunta")
	public List<Respuesta> getRespuestas() {
		return this.respuestas;
	}

	public void setRespuestas(final List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	//@Valid
//	@ManyToOne(optional=false)
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
		return Objects.equals(textoPregunta, pregunta.textoPregunta) &&
				Objects.equals(tipoPregunta, pregunta.tipoPregunta);
	}

	@Override
	public int hashCode() {

		return Objects.hash(textoPregunta, tipoPregunta);
	}


}